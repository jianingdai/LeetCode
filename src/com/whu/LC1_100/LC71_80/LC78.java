package com.whu.LC1_100.LC71_80;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) return result;
            dfs(nums, 0);
            return result;
        }

        private void dfs(int[] nums, int index) {
            result.add(new ArrayList<>(path));//记录当前路径
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);//选择当前元素
                dfs(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
