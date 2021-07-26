package ru.job4j.cache;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        System.out.println("==== Loading file " + key + " to cache... ====");
        String fileContent = getFileContent(cachingDir + "\\" + key);
        put(key, fileContent);
        return fileContent;
    }

    protected String getFileContent(String path) {
        String rsl = null;
        try {
            rsl = Files.readString(Path.of(path), Charset.forName("windows-1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

}
