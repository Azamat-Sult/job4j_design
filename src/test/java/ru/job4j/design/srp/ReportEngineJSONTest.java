package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineJSONTest {

    @Test
    public void whenToJSONThenEqualFromJSON() {
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

        Gson gson = new GsonBuilder().create();
        List<Employee> expected = json.lines()
                .map(line -> gson.fromJson(line, Employee.class))
                .collect(Collectors.toList());

        assertThat(expected.get(0).getName(), is(worker1.getName()));
        assertThat(expected.get(0).getHired().getTime().toString(), is(worker1.getHired().getTime().toString()));
        assertThat(expected.get(0).getFired().getTime().toString(), is(worker1.getFired().getTime().toString()));
        assertThat(expected.get(0).getSalary(), is(worker1.getSalary()));

        assertThat(expected.get(1).getName(), is(worker2.getName()));
        assertThat(expected.get(1).getHired().getTime().toString(), is(worker2.getHired().getTime().toString()));
        assertThat(expected.get(1).getFired().getTime().toString(), is(worker2.getFired().getTime().toString()));
        assertThat(expected.get(1).getSalary(), is(worker2.getSalary()));

        assertThat(expected.get(2).getName(), is(worker3.getName()));
        assertThat(expected.get(2).getHired().getTime().toString(), is(worker3.getHired().getTime().toString()));
        assertThat(expected.get(2).getFired().getTime().toString(), is(worker3.getFired().getTime().toString()));
        assertThat(expected.get(2).getSalary(), is(worker3.getSalary()));
    }

}