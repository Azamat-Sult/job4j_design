package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "ReportXML")
@XmlRootElement
public class ReportXML {

    @XmlElementWrapper(name = "Employees")
    @XmlElement(name = "Employee")
    private List<Employee> employees;

    public ReportXML() {
    }

    public ReportXML(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
