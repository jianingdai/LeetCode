package com.whu.LC151_160;

import java.util.Arrays;

public class LC153 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[right];
        }
    }
}
