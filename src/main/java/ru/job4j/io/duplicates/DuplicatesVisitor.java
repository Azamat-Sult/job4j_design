package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    HashMap<FileProperty, String> uniqueFileBase = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty newFile = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (file.toFile().isFile() && uniqueFileBase.containsKey(newFile)) {
            System.out.println("Duplicate found:");
            System.out.println(uniqueFileBase.get(newFile));
            System.out.println(file.toAbsolutePath());
            System.out.println();
        } else {
            uniqueFileBase.put(newFile, file.toAbsolutePath().toString());
        }
        return super.visitFile(file, attrs);
    }
}
