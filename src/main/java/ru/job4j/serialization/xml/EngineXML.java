package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class EngineXML {

    @XmlAttribute
    private int power;
    @XmlAttribute
    private double volumeLitres;
    @XmlAttribute
    private int numOfValves;

    public EngineXML() {
    }

    public EngineXML(int power, double volumeLitres, int numOfValves) {
        this.power = power;
        this.volumeLitres = volumeLitres;
        this.numOfValves = numOfValves;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "power=" + power
                + ", volumeLitres=" + volumeLitres
                + ", numOfValves=" + numOfValves + '}';
    }
}
