package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void testMixActions() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        before.add(new Analize.User(100, "Ivan"));
        before.add(new Analize.User(200, "Boris"));
        before.add(new Analize.User(300, "John"));
        ArrayList<Analize.User> after = new ArrayList<>();
        after.add(new Analize.User(200, "Boris"));
        after.add(new Analize.User(300, "Denis"));
        after.add(new Analize.User(400, "Bob"));
        after.add(new Analize.User(500, "Jerry"));
        assertThat(obj.diff(before, after).added, is(2));
        assertThat(obj.diff(before, after).changed, is(1));
        assertThat(obj.diff(before, after).deleted, is(1));
    }

    @Test
    public void testAllDeleted() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        before.add(new Analize.User(100, "Ivan"));
        before.add(new Analize.User(200, "Boris"));
        before.add(new Analize.User(300, "John"));
        before.add(new Analize.User(400, "Bob"));
        before.add(new Analize.User(500, "Jerry"));
        ArrayList<Analize.User> after = new ArrayList<>();
        assertThat(obj.diff(before, after).added, is(0));
        assertThat(obj.diff(before, after).changed, is(0));
        assertThat(obj.diff(before, after).deleted, is(5));
    }

    @Test
    public void testAllChanged() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        before.add(new Analize.User(100, "Ivan"));
        before.add(new Analize.User(200, "Boris"));
        before.add(new Analize.User(300, "John"));
        before.add(new Analize.User(400, "Bob"));
        before.add(new Analize.User(500, "Jerry"));
        ArrayList<Analize.User> after = new ArrayList<>();
        after.add(new Analize.User(100, "Ivan Changed"));
        after.add(new Analize.User(200, "Boris Changed"));
        after.add(new Analize.User(300, "John Changed"));
        after.add(new Analize.User(400, "Bob Changed"));
        after.add(new Analize.User(500, "Jerry Changed"));
        assertThat(obj.diff(before, after).added, is(0));
        assertThat(obj.diff(before, after).changed, is(5));
        assertThat(obj.diff(before, after).deleted, is(0));
    }

    @Test
    public void testAllAdded() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        ArrayList<Analize.User> after = new ArrayList<>();
        after.add(new Analize.User(100, "Ivan"));
        after.add(new Analize.User(200, "Boris"));
        after.add(new Analize.User(300, "John"));
        after.add(new Analize.User(400, "Bob"));
        after.add(new Analize.User(500, "Jerry"));
        assertThat(obj.diff(before, after).added, is(5));
        assertThat(obj.diff(before, after).changed, is(0));
        assertThat(obj.diff(before, after).deleted, is(0));
    }

    @Test
    public void testNotChanged() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        before.add(new Analize.User(100, "Ivan"));
        before.add(new Analize.User(200, "Boris"));
        before.add(new Analize.User(300, "John"));
        before.add(new Analize.User(400, "Bob"));
        before.add(new Analize.User(500, "Jerry"));
        ArrayList<Analize.User> after = new ArrayList<>();
        after.add(new Analize.User(100, "Ivan"));
        after.add(new Analize.User(200, "Boris"));
        after.add(new Analize.User(300, "John"));
        after.add(new Analize.User(400, "Bob"));
        after.add(new Analize.User(500, "Jerry"));
        assertThat(obj.diff(before, after).added, is(0));
        assertThat(obj.diff(before, after).changed, is(0));
        assertThat(obj.diff(before, after).deleted, is(0));
    }

    @Test
    public void testNotChangedAndEmpty() {
        Analize obj = new Analize();
        ArrayList<Analize.User> before = new ArrayList<>();
        ArrayList<Analize.User> after = new ArrayList<>();
        assertThat(obj.diff(before, after).added, is(0));
        assertThat(obj.diff(before, after).changed, is(0));
        assertThat(obj.diff(before, after).deleted, is(0));
    }

}