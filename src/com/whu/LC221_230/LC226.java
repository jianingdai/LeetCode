package com.whu.LC221_230;

import com.whu.TreeNode;

public class LC226 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            _invert(root);
            return root;
        }

        private void _invert(TreeNode node) {
//            后序
            if (node == null) {
                return;
            }
            _invert(node.left);
            _invert(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
