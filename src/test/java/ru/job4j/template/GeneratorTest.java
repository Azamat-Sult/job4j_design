package ru.job4j.template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest {

    /*@Test(expected = NoSuchKeyInMapException.class)
    public void whenGenerateThenKeyNotFoundInMap() throws NoSuchKeyInMapException, NoSuchKeyInTemplateException {
        Generator generator = new StringGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jerry");
        String rsl = generator.produce("${age}, ${address}", map);
    }

    @Test(expected = NoSuchKeyInTemplateException.class)
    public void whenGenerateThenKeyNotFoundInTemplate() throws NoSuchKeyInTemplateException, NoSuchKeyInMapException {
        Generator generator = new StringGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jerry");
        map.put("age", "21");
        String rsl = generator.produce("${age}", map);
    }*/
}
