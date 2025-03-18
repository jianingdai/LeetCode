package com.whu.LC91_100;

import com.whu.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC94 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorder(root, result);
            return result;
        }

        public void inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorder(root.left, result);

            result.add(root.val);

            inorder(root.right, result);
        }
    }
}
