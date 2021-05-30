package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;

public class Analizy {
    public void unavailable(String source, String target) {
        ArrayList<String> offLineLog = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            String offLineTime = "";
            while ((line = in.readLine()) != null) {
                String[] lineSplitted = line.split(" ");
                if (offLineTime.isBlank() && (lineSplitted[0].equals("400") || lineSplitted[0].equals("500"))) {
                    offLineTime = offLineTime.concat(lineSplitted[1]).concat(";");
                }
                if (!offLineTime.isBlank() && (lineSplitted[0].equals("200") || lineSplitted[0].equals("300"))) {
                    offLineTime = offLineTime.concat(lineSplitted[1]).concat(";");
                    offLineLog.add(offLineTime);
                    offLineTime = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveResultsToFile(offLineLog, target);
    }

    public void saveResultsToFile(ArrayList<String> rsl, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String line : rsl) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
