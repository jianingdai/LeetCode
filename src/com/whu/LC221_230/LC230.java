package com.whu.LC221_230;

import com.whu.ListNode;
import com.whu.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LC230 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        ArrayList<Integer> list = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                --k;
                if (k == 0) {
                    break;
                }
                root = root.right;
            }
            return root.val;
        }
    }
}
