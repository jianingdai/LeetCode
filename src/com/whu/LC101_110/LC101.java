package com.whu.LC101_110;

import com.whu.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC101 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return A(root.left, root.right);
        }

        private boolean A(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;//两个null
            if (left == null || right == null) return false;//只有一个null
            return left.val == right.val && A(left.right, right.left) && A(left.left, right.right);
        }
    }
}
