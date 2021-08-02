package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineXMLTest {

    @Test
    public void whenToXMLThenEqualFromXML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Bob", now, now, 1000);
        Employee worker3 = new Employee("Jane", now, now, 2000);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engineXML = new ReportEngineXML(store);
        String xml = engineXML.generate(em -> true);

        ReportXML expected = new ReportXML();
        try {
            expected = ReportEngineXML.fromXML(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        Employee expWorker1 = expected.getEmployees().get(0);
        Employee expWorker2 = expected.getEmployees().get(1);
        Employee expWorker3 = expected.getEmployees().get(2);

        assertThat(expWorker1.getName(), is(worker1.getName()));
        assertThat(expWorker1.getHired().getTime(), is(worker1.getHired().getTime()));
        assertThat(expWorker1.getFired().getTime(), is(worker1.getFired().getTime()));
        assertThat(expWorker1.getSalary(), is(worker1.getSalary()));

        assertThat(expWorker2.getName(), is(worker2.getName()));
        assertThat(expWorker2.getHired().getTime(), is(worker2.getHired().getTime()));
        assertThat(expWorker2.getFired().getTime(), is(worker2.getFired().getTime()));
        assertThat(expWorker2.getSalary(), is(worker2.getSalary()));

        assertThat(expWorker3.getName(), is(worker3.getName()));
        assertThat(expWorker3.getHired().getTime(), is(worker3.getHired().getTime()));
        assertThat(expWorker3.getFired().getTime(), is(worker3.getFired().getTime()));
        assertThat(expWorker3.getSalary(), is(worker3.getSalary()));
    }

}