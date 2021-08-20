package ru.job4j.io;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CSVReaderV2 {
    private String sourceFilePath;
    private String delimiter;
    private String outputDest;
    private Set<Integer> filterColNum;

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
        this.filterColNum = findFilterColNum(Set.of(args.get("filter").split(",")));
    }

    private Set<Integer> findFilterColNum(Set<String> filterColNames) {
        Set<Integer> rsl = new HashSet<>();
        try {
            Scanner scanner = new Scanner(Path.of(sourceFilePath));
            String[] line = new String[0];
            if (scanner.hasNext()) {
                line = scanner.nextLine().split(delimiter);
            }
            for (int index = 0; index < line.length; index++) {
                if (filterColNames.contains(line[index])) {
                    rsl.add(index);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void filterAndSaveCSV() {
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

                Scanner scanner = new Scanner(Path.of(sourceFilePath));
                String[] line;
                StringBuilder lineToSave = new StringBuilder();

                while (scanner.hasNext()) {
                    line = scanner.nextLine().split(delimiter);

                    for (int index = 0; index < line.length; index++) {
                        if (filterColNum.contains(index)) {
                            lineToSave.append(line[index]).append(delimiter);
                        }
                    }

                    out.println(lineToSave.substring(0, lineToSave.length() - 1));
                    lineToSave = new StringBuilder();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CSVReaderV2 csvReader = new CSVReaderV2();
        csvReader.initArgs(args);
        csvReader.filterAndSaveCSV();
    }
}
