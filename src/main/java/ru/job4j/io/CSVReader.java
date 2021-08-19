package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CSVReader {
    private String sourceFilePath;
    private String delimiter;
    private String outputDest;
    private Set<String> filter;
    private final List<String[]> csvFileContent = new ArrayList<>();

    private void initArgs(String[] arguments) {
        if (arguments.length != 4) {
            throw new IllegalArgumentException("\n Correct usage: \n"
                    + "java -jar target/csvReader.jar "
                    + "-path=SOURCE_FILE.CSV "
                    + "-delimiter=\";\" "
                    + "-out=stdout/DEST_FILE.CSV "
                    + "-filter=COLUMN_1, ..  , COLUMN_N");
        }

        ArgsName args = ArgsName.of(arguments);
        this.sourceFilePath = args.get("path");
        this.delimiter = args.get("delimiter");
        this.outputDest = args.get("out");
        this.filter = Set.of(args.get("filter").split(","));

    }

    private void loadCSV() {
        try {
            Scanner scanner = new Scanner(Path.of(sourceFilePath));
            while (scanner.hasNext()) {
                csvFileContent.add(scanner.nextLine().split(delimiter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void filterCSV() {
        for (int index = 0; index < csvFileContent.get(0).length; index++) {
            if (!filter.contains(csvFileContent.get(0)[index])) {
                for (String[] line : csvFileContent) {
                    line[index] = null;
                }
            }
        }
    }

    private void outputCSV() {
        PrintStream outDest = null;
        if (outputDest.equals("stdout")) {
            outDest = System.out;
        } else {
            try {
                outDest = new PrintStream(outputDest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (outDest != null) {
            try (PrintWriter out = new PrintWriter(outDest)) {
                StringBuilder line = new StringBuilder();
                for (String[] array : csvFileContent) {
                    for (String s : array) {
                        if (s != null) {
                            line.append(s).append(delimiter);
                        }
                    }
                    out.println(line.substring(0, line.length() - 1));
                    line = new StringBuilder();
                }
            }
        }
    }

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        csvReader.initArgs(args);
        csvReader.loadCSV();
        csvReader.filterCSV();
        csvReader.outputCSV();
    }
}
