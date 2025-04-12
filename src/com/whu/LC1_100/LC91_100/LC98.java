package com.whu.LC1_100.LC91_100;

import com.whu.TreeNode;

public class LC98 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isValidBST(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean validate(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        }
    }
}
