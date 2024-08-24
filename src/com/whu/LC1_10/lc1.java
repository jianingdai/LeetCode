package com.whu.LC1_10;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.cn/problems/two-sum/description/
两数之和
* */
public class lc1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    private static class Solution {
        public int[] twoSum(int[] nums, int target) {
//            O(N)的复杂度
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                boolean flag = false;
                int pei = target - nums[i];
                int j = -1;
                if ((j = map.get(pei) == null ? j : map.get(pei)) != -1) {
//                    先检查是否已经存在配对
                    flag = true;
                }
                if (flag) {
//                  找到配对元素返回
                    return new int[]{j, i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}

