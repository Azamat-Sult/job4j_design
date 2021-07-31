package ru.job4j.design.srp;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineHTMLTest {
    @Test
    public void whenHTMLGenerated() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyy");
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 1000);
        store.add(worker);
        Report engineHTML = new ReportEngineHTML(store);

        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">")
                .append(System.lineSeparator())
                .append("<title>Report for developers</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator())
                .append("<h1>Report for developers</h1>")
                .append(System.lineSeparator())
                .append("<table>")
                .append(System.lineSeparator())
                .append("<tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator())
                .append("<tr><td>").append(worker.getName())
                .append("</td><td>").append(df.format(worker.getHired().getTime()))
                .append("</td><td>").append(df.format(worker.getFired().getTime()))
                .append("</td><td>").append(worker.getSalary())
                .append("</td></tr>")
                .append(System.lineSeparator())
                .append("</table>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");

        assertThat(engineHTML.generate(em -> true), is(expect.toString()));
    }
}