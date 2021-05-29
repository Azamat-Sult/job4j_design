package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void TestAnalyzeServer1() {
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
    public void TestAnalyzeServer2() {
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
}