package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterInEmpty() {
        List<Integer> input = new ArrayList<>();
        ListUtils.addAfter(input, 0, 1);
        assertThat(Collections.singletonList(1), Is.is(input));
    }

    @Test
    public void whenRemoveIfPredicate1() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.removeIf(input, (x) -> x >= 2 && x <= 4);
        assertThat(Arrays.asList(1, 5), Is.is(input));
    }

    @Test
    public void whenRemoveIfPredicate2() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.removeIf(input, (x) -> x % 2 == 0);
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIfPredicate1() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.replaceIf(input, (x) -> x % 2 != 0, 100);
        assertThat(Arrays.asList(100, 2, 100, 4, 100), Is.is(input));
    }

    @Test
    public void whenReplaceIfPredicate2() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.replaceIf(input, (x) -> x > 3, -1);
        assertThat(Arrays.asList(1, 2, 3, -1, -1), Is.is(input));
    }

    @Test
    public void removeAll() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.removeAll(input, Arrays.asList(1, 3, 5));
        assertThat(Arrays.asList(2, 4), Is.is(input));
    }

    @Test
    public void removeEmptyList() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ListUtils.removeAll(input, Collections.emptyList());
        assertThat(Arrays.asList(1, 2, 3, 4, 5), Is.is(input));
    }

    @Test
    public void removeFromEmptyList() {
        List<Integer> input = new ArrayList<>();
        ListUtils.removeAll(input, Arrays.asList(1, 3, 5));
        assertThat(Collections.emptyList(), Is.is(input));
    }

}
