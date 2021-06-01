package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private String dirToZip;
    private String excludeExtension;
    private File zipFile;

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path sourceFile : sources) {
                zipOut.putNextEntry(new ZipEntry(sourceFile.toFile().getPath()));
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile.toFile()))) {
                    zipOut.write(in.readAllBytes());
                }
                zipOut.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zipOut.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
                zipOut.write(in.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initArgs(String[] arguments) {
        if (arguments.length != 3) {
            throw new IllegalArgumentException("\n Correct usage: \n"
                    + " java -jar zip.jar -d=DIR_TO_ZIP -e=EXCLUDE_EXTENSION -o=ZIP_NAME");
        }
        ArgsName zipArgs = ArgsName.of(arguments);
        this.dirToZip = zipArgs.get("d");
        this.excludeExtension = zipArgs.get("e");
        this.zipFile = new File(zipArgs.get("o"));
    }

    private List<Path> searchExclExt(String dirPath, String exclExt) {
        List<Path> rsl = null;
        try {
            rsl = Search.search(Paths.get(dirPath), p -> !p.toFile()
                    .getName()
                    .endsWith(exclExt));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        Zip zipDir = new Zip();
        zipDir.initArgs(args);
        List<Path> toZip = zipDir.searchExclExt(zipDir.dirToZip, zipDir.excludeExtension);
        zipDir.packFiles(toZip, zipDir.zipFile);
    }
}
