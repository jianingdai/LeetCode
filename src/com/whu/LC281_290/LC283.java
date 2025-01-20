package com.whu.LC281_290;

import com.whu.AAA;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class LC283 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0 || nums.length == 1) return;
            int nonZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
//                    如果当前元素非零就把他放到非零元素的末尾
                    int temp = nums[nonZeroIndex];
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = temp;
                    nonZeroIndex++;
                }
            }
        }
    }
}
