package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void testAnalyzeServer1() {
        String source = "./data/server1.log";
        String dest = "./data/server1_analyzed.log";
        ArrayList<String> expectedLog = new ArrayList<>();
        ArrayList<String> currentLog = new ArrayList<>();
        expectedLog.add("10:57:01;10:59:01;");
        expectedLog.add("11:01:02;11:02:02;");
        Analizy check = new Analizy();
        check.unavailable(source, dest);
        try (BufferedReader in = new BufferedReader(new FileReader(dest))) {
            String line;
            while ((line = in.readLine()) != null) {
                currentLog.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(currentLog, is(expectedLog));
    }

    @Test
    public void testAnalyzeServer2() {
        String source = "./data/server2.log";
        String dest = "./data/server2_analyzed.log";
        ArrayList<String> expectedLog = new ArrayList<>();
        ArrayList<String> currentLog = new ArrayList<>();
        expectedLog.add("10:57:01;11:02:02;");
        Analizy check = new Analizy();
        check.unavailable(source, dest);
        try (BufferedReader in = new BufferedReader(new FileReader(dest))) {
            String line;
            while ((line = in.readLine()) != null) {
                currentLog.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(currentLog, is(expectedLog));
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testAnalyzeServer1InTempFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy check = new Analizy();
        check.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        String expected = "10:57:01;10:59:01;"
                + "11:01:02;11:02:02;";
        assertThat(rsl.toString(), is(expected));
    }

    @Test
    public void testAnalyzeServer2InTempFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy check = new Analizy();
        check.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        String expected = "10:57:01;11:02:02;";
        assertThat(rsl.toString(), is(expected));
    }
}