package com.whu.LC101_110;

import com.whu.TreeNode;

import java.util.*;

public class LC102 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;//如果根节点为空，直接返回空列表
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);//根节点加入队列

            while (!queue.isEmpty()) {
                int levelSize = queue.size();//当前层的节点数

                List<Integer> currentLevel = new ArrayList<>();//存储当前节点的值
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();//出队一个节点
                    currentLevel.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(currentLevel);
            }
            return result;
        }
    }
}
