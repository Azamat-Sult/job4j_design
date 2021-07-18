package ru.job4j.gc;

import org.openjdk.jol.info.ClassLayout;

public class MemoryUsageDemo {

    public static void main(String[] args) {

        //System.out.println(ClassLayout.parseInstance(new User(3, "N3", true)).toPrintable());
        //System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());

        for (int i = 0; i < 40000; i++) {
            new User(i, "User object N" + i, true);
        }
    }
}
