package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        byte var1 = 1;
        short var2 = 2;
        int var3 = 3;
        long var4 = 4;
        float var5 = 5;
        double var6 = 6;
        boolean var7 = true;
        char var8 = 'y';
        LOG.debug("byte : {}, short : {}, int : {}, long : {}", var1, var2, var3, var4);
        LOG.debug("float : {}, double : {}, boolean : {}, char : {}", var5, var6, var7, var8);
    }
}