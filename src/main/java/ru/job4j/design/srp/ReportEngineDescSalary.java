package ru.job4j.design.srp;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineDescSalary implements Report {

    private final Store store;

    public ReportEngineDescSalary(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);
        List<Employee> sortedStore = store.findBy(filter);
        sortedStore.sort(salaryComparator.reversed());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : sortedStore) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
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
        Report engineDescSalary = new ReportEngineDescSalary(store);
        System.out.println(engineDescSalary.generate(em -> true));
    }
}
