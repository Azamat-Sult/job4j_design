package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {

        String dir = "C:\\Projects\\job4j_design";

        DirFileCache txtCache = new DirFileCache(dir);

        Scanner scanner = new Scanner(System.in);

        boolean run = true;

        while (run) {

            System.out.println();
            System.out.println("0. Select caching directory. (current - " + dir + ")");
            System.out.println("1. Load file to cache");
            System.out.println("2. Get file from cache");
            System.out.println("3. Exit program");
            System.out.print("Select: ");
            
            int select = Integer.parseInt(scanner.nextLine());

            if (select == 0) {
                System.out.print("Enter directory to be cached, (example - C:\\Projects\\job4j_design): ");
                dir = scanner.nextLine();
                txtCache = new DirFileCache(dir);
                continue;
            }

            if (select == 1) {
                System.out.print("Enter file name to be cached, (example - botDict.txt): ");
                String fileToLoad = scanner.nextLine();
                txtCache.load(fileToLoad);
                continue;
            }

            if (select == 2) {
                System.out.print("Enter file name to display, (example - botDict.txt): ");
                String fileToPrint = scanner.nextLine();
                System.out.println(txtCache.get(fileToPrint));
            }

            if (select == 3) {
                run = false;
            }
        }
    }
}
