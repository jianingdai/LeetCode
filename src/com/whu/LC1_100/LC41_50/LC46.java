package com.whu.LC1_100.LC41_50;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used;
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));//添加当前排序
                return;
            }
            for (int i = 0; i < nums.length; i++) {
//                跳过已经使用过的元素
                if (used[i]) continue;
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums);//递归生成下一层选择
                path.remove(path.size() - 1);//回溯：撤销选择
                used[i] = false;
            }
        }
    }
}
