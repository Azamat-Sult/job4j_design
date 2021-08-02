package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineXML implements Report {

    private final Store store;

    public ReportEngineXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String rsl = null;
        try {
            rsl = toXML(new ReportXML(store.findBy(filter)));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public String toXML(ReportXML report) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Employee.class, ReportXML.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(report, writer);
        return writer.toString();
    }

    public static ReportXML fromXML(String xmlString) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employee.class, ReportXML.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ReportXML result = null;
        try (StringReader reader = new StringReader(xmlString)) {
            result = (ReportXML) unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
        Report engineXML = new ReportEngineXML(store);
        String xml = engineXML.generate(em -> true);
        System.out.println(xml);

        ReportXML expected = new ReportXML();
        try {
            expected = ReportEngineXML.fromXML(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        for (Employee emp : expected.getEmployees()) {
            System.out.println(emp);
        }
    }
}
