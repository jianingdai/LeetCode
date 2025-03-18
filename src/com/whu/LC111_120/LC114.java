package com.whu.LC111_120;

import com.whu.TreeNode;

public class LC114 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public void flatten(TreeNode root) {
//            对于每个节点curr：
//            找到左子树的最右节点（即左子树中最后被前序遍历的节点，成为pre）
//            将curr的右子树接到pre的右侧
//            将curr的左子树变为右子树，左指针置空
            TreeNode curr = root;
            ;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode pre = curr.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
                curr = curr.right;
            }
        }
    }
}
