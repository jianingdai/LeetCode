package com.whu.LC431_440;

import com.whu.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

public class LC437 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        int count = 0;//结果
        int target;
        Map<Long, Integer> prefixMap = new HashMap<>();//前缀和出现次数

        public int pathSum(TreeNode root, int targetSum) {
            target = targetSum;
//            初始化前缀和
            prefixMap.put(0L, 1);
            dfs(root, 0);
            return count;
        }

        void dfs(TreeNode node, long currentSum) {
            if (node == null) return;

            currentSum += node.val;//当前路径的路径和
//            检查
            count += prefixMap.getOrDefault(currentSum - target, 0);

            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);

//            递归左右子树
            dfs(node.left, currentSum);
            dfs(node.right, currentSum);

//            回溯：恢复状态以免影响其他路径
            prefixMap.put(currentSum, prefixMap.get(currentSum) - 1);
        }
    }
}
