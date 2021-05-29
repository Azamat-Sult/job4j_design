package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects\\job4j_design");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println("|---------------------|-----------|");
        System.out.println("|      File name      |size, bytes|");
        System.out.println("|---------------------|-----------|");
        for (File subfile : file.listFiles()) {
            if (subfile.isFile()) {
                System.out.printf("| %-20s| %10d|%n", subfile.getName(), subfile.length());
            }
        }
        System.out.println("|---------------------|-----------|");
    }
}
