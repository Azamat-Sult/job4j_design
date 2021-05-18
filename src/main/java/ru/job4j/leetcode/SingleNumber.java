package ru.job4j.leetcode;

import java.util.HashSet;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet numSet = new HashSet();
        for (int index = 0; index < nums.length; index++) {
            if (!numSet.contains(nums[index])) {
                numSet.add(nums[index]);
            } else {
                numSet.remove(nums[index]);
            }
        }
        return (int) numSet.toArray()[0];
    }
}
