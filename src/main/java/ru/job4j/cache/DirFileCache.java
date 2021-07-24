package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

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
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(path, Charset.forName("WINDOWS-1251")))) {
            String line;
            while ((line = in.readLine()) != null) {
                rsl.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl.toString();
    }

}
