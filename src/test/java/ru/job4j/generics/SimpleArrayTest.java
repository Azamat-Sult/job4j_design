package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddMoreThanLengthThenException() {
        SimpleArray sArr = new SimpleArray(1);
        sArr.add("normal");
        sArr.add("exception");
    }

    @Test
    public void whenAddNormThenGetNorm() {
        SimpleArray sArr = new SimpleArray(2);
        sArr.add(false);
        sArr.add(true);
        assertThat(sArr.get(0), is(false));
        assertThat(sArr.get(1), is(true));
    }

    @Test
    public void whenSetNormThenReplacedNorm() {
        SimpleArray sArr = new SimpleArray(3);
        sArr.add("first");
        sArr.add("second");
        sArr.add("third");
        sArr.set(2, "replaced");
        assertThat(sArr.get(2), is("replaced"));
    }

    @Test
    public void whenBeginDelThenDeleted() {
        SimpleArray sArr = new SimpleArray(3);
        sArr.add("deleted");
        sArr.add("second");
        sArr.add("third");
        sArr.remove(0);
        assertThat(sArr.get(0), is("second"));
        assertThat(sArr.get(1), is("third"));
    }

    @Test
    public void whenMidDelThenDeleted() {
        SimpleArray sArr = new SimpleArray(3);
        sArr.add("first");
        sArr.add("deleted");
        sArr.add("third");
        sArr.remove(1);
        assertThat(sArr.get(0), is("first"));
        assertThat(sArr.get(1), is("third"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenLastDelThenGetDeletedException() {
        SimpleArray sArr = new SimpleArray(3);
        sArr.add("first");
        sArr.add("second");
        sArr.add("deleted");
        sArr.remove(2);
        assertThat(sArr.get(2), is("deleted"));
    }

    @Test
    public void whenHasNext() {
        SimpleArray sArr = new SimpleArray(1);
        sArr.add("first");
        assertTrue(sArr.iterator().hasNext());
    }

    @Test
    public void whenEmpty() {
        SimpleArray sArr = new SimpleArray(1);
        assertFalse(sArr.iterator().hasNext());
    }

    @Test
    public void whenHasNextThenDoubleNext() {
        SimpleArray sArr = new SimpleArray(2);
        sArr.add("first");
        sArr.add("second");
        assertThat(sArr.iterator().next(), is("first"));
        assertThat(sArr.iterator().next(), is("second"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThenNextException() {
        SimpleArray sArr = new SimpleArray(1);
        assertThat(sArr.iterator().next(), is("Exception"));
    }
}
