package com.whu.LC541_550;

import com.whu.TreeNode;

import java.awt.print.PrinterAbortException;

public class LC543 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            maxDepthLeftRight(root);
            return ans - 1;
        }

        private int maxDepthLeftRight(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int L = maxDepthLeftRight(node.left);
            int R = maxDepthLeftRight(node.right);
            ans = Math.max(ans, L + R + 1);
            return Math.max(L, R) + 1;
        }
    }
}
