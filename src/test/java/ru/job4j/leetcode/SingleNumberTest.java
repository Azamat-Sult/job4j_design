package ru.job4j.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SingleNumberTest {

    @Test
    public void test1() {
        int[] nums = {2, 2, 1};
        SingleNumber sNum = new SingleNumber();
        assertThat(sNum.singleNumber(nums), is(1));
    }

    @Test
    public void test2() {
        int[] nums = {4, 1, 2, 1, 2};
        SingleNumber sNum = new SingleNumber();
        assertThat(sNum.singleNumber(nums), is(4));
    }

}