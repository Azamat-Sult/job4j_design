package ru.job4j.design.srp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineHTML implements Report {

    private Store store;

    public ReportEngineHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyy");
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>")
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
                .append(System.lineSeparator());
        text.append("<tr><th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th></tr>")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr><td>").append(employee.getName())
                    .append("</td><td>").append(df.format(employee.getHired().getTime()))
                    .append("</td><td>").append(df.format(employee.getFired().getTime()))
                    .append("</td><td>").append(employee.getSalary())
                    .append("</td></tr>")
                    .append(System.lineSeparator());
        }
        text.append("</table>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>");
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 1000);
        store.add(worker1);
        store.add(worker2);
        Report engineHTML = new ReportEngineHTML(store);
        System.out.println(engineHTML.generate(em -> true));
    }
}
