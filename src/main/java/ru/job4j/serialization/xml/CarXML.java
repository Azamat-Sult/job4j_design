package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarXML {

    @XmlAttribute
    private boolean wasInAccident;
    @XmlAttribute
    private int age;
    @XmlAttribute
    private String model;
    private EngineXML engine;
    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    private String[] equipment;

    public CarXML() {
    }

    public CarXML(boolean wasInAccident, int age, String model, EngineXML engine, String... equipment) {
        this.wasInAccident = wasInAccident;
        this.age = age;
        this.model = model;
        this.engine = engine;
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{"
                + "wasInAccident=" + wasInAccident
                + ", age=" + age
                + ", model='" + model + '\''
                + ", engine=" + engine
                + ", equipment=" + Arrays.toString(equipment) + '}';
    }
}
