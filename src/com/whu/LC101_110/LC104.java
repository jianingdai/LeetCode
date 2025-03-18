package com.whu.LC101_110;

import com.whu.TreeNode;

import javax.management.openmbean.CompositeType;

public class LC104 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            return postOrder(root);
        }

        private int postOrder(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftNum = postOrder(node.left);
            int rightNum = postOrder(node.right);
            return Math.max(leftNum + 1, rightNum + 1);
        }
    }
}
