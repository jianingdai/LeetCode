package com.whu.LC1_100.LC31_40;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    private static class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//          回溯
            if (candidates == null || candidates.length == 0) return resList;
            dfs(candidates, target, 0, 0);
            return resList;
        }

        private void dfs(int[] candidates, int target, int sum, int startIndex) {
            if (sum == target) {
                resList.add(new ArrayList<>(pathList));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {
                sum += candidates[i];
                pathList.add(candidates[i]);
                dfs(candidates, target, sum, i);
                sum = sum - candidates[i];
                pathList.remove(pathList.size() - 1);
            }
        }
    }
}
