package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineNewView implements Report {

    private Store store;

    public ReportEngineNewView(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / 1000).append(" thousands of rubles").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 1000);
        Employee worker3 = new Employee("Jane", now, now, 660);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engineNewView = new ReportEngineNewView(store);
        System.out.println(engineNewView.generate(em -> true));
    }
}
