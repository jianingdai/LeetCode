package com.whu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC31 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public void nextPermutation(int[] nums) {
//            如果当前排列是完全降序排列那么直接返回一个升序排列
            boolean flag = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                Arrays.sort(nums);
                return;
            } else {
//                从右至左找到第一个不递增的数
                int index = nums.length - 1;
                for (int i = nums.length - 1; i > 0; i--) {
                    if (nums[i - 1] < nums[i]) {
                        index = i - 1;
                        break;
                    }
                }

//                从该数左至右找到第一个刚好大于该数的最小的数
                int min = 0x7fffffff;
                int minIndex = -1;
                for (int i = index + 1; i < nums.length; i++) {
                    if (nums[i] == nums[index] + 1) {
                        min = nums[i];
                        minIndex = i;
                        break;
                    }
                    if (nums[i] > nums[index]) {
                        min = Math.min(min, nums[i]);
                        minIndex = i;
                    }
                }
                nums[minIndex] = nums[index];
                nums[index] = min;
                Arrays.sort(nums, index + 1, nums.length);
            }
        }
    }
}
