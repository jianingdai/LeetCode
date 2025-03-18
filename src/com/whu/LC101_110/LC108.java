package com.whu.LC101_110;

import com.whu.TreeNode;

import javax.swing.*;

public class LC108 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return divideAndRule(nums, 0, nums.length - 1);
        }

        private TreeNode divideAndRule(int[] nums, int left, int right) {
//            同时要完成构建的任务
//            返回值是中间的元素
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode midNode = new TreeNode(nums[mid]);
            midNode.left = divideAndRule(nums, left, mid - 1);
            midNode.right = divideAndRule(nums, mid + 1, right);
            return midNode;
        }
    }
}
