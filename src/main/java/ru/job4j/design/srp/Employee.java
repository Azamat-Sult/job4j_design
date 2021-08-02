package ru.job4j.design.srp;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@XmlType(name = "Employee")
public class Employee {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private Calendar hired;
    @XmlAttribute
    private Calendar fired;
    @XmlAttribute
    private double salary;

    public Employee() {
    }

    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Calendar getHired() {
        return hired;
    }

    public Calendar getFired() {
        return fired;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0
                && Objects.equals(name, employee.name)
                && Objects.equals(hired.getTime(), employee.hired.getTime())
                && Objects.equals(fired.getTime(), employee.fired.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired.getTime(), fired.getTime(), salary);
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyy");
        return "Employee{ " + "name='" + name + '\'' + ", hired=" + df.format(hired.getTime())
                + ", fired=" + df.format(fired.getTime()) + ", salary=" + salary + " }";
    }
}
