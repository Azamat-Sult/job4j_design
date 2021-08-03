package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineJSON implements Report {

    private final Store store;

    public ReportEngineJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(store.findBy(filter));
    }

    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 1000);
        Employee worker3 = new Employee("Jane", now, now, 2000);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engineJSON = new ReportEngineJSON(store);
        String json = engineJSON.generate(em -> true);
        System.out.println(json);

        Gson gson = new GsonBuilder().create();
        Type collectionType = new TypeToken<List<Employee>>() { }.getType();
        List<Employee> expected = gson.fromJson(json, collectionType);

        for (Employee emp : expected) {
            System.out.println(emp);
        }
    }
}
