package com.whu.LC1_100.LC31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> pathList = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) return resList;
            Arrays.sort(candidates);
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
                if (i != startIndex && candidates[i] == candidates[i - 1]) continue;
                sum += candidates[i];
                pathList.add(candidates[i]);
                dfs(candidates, target, sum, i + 1);
                sum -= candidates[i];
                pathList.remove(pathList.size() - 1);
            }
        }
    }
}
