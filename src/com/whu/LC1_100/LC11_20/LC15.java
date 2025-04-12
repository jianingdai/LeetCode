package com.whu.LC1_100.LC11_20;
/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
* */

import java.util.*;

public class LC15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{1,-1,-1,0});
        System.out.println(lists);
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
//            先对nums排序
            Arrays.sort(nums);
//            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < nums.length - 2; i++) {
//                转成两数之和,剪枝
                int goal = -nums[i];
                if (nums[i + 1] + nums[i + 2] > goal) {
//                        nums[i]只会越来越大,goal越来越小,直到最小的两个都不满足条件时跳出程序
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int left = i + 1, right = nums.length - 1; left < right; ) {
//                    目标值前结果都已经得出,两个指针只需要后走
                    if (nums[left] + nums[right] > goal) {
                        right--;
                    } else if (nums[left] + nums[right] < goal) {
                        left++;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        res.add(list);
                        while (left < right && nums[left] == nums[++left]) ;
                        while (left < right && nums[right] == nums[--right]) ;
                    }
                }
            }
            return res;
        }
    }
}
