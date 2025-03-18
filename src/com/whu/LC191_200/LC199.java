package com.whu.LC191_200;

import com.whu.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> result = new LinkedList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == size - 1) {
//                        如果是本层最后一个那么就加入到result中
                        result.add(node.val);
                    }
                    if (node.left != null) {
                        //如果左子树不为空那么就加入到队列中
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        //如果右子树不为空那么就加入到队列中
                        queue.offer(node.right);
                    }
                }
            }
            return result;
        }
    }
}
