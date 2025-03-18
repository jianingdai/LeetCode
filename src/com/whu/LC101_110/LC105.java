package com.whu.LC101_110;

import com.whu.TreeNode;

import java.util.HashMap;

public class LC105 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            /*  前序遍历的首元素是当前子树的根节点
            再中序遍历中找到根节点位置，左侧是左子树，右侧是右子树
            用子数组递归构造左子树和右子树
            * */
            for (int i = 0; i < inorder.length; i++) {
//                用哈希表记录中序元素的位置
                indexMap.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd) {
//                终止条件
                return null;
            }
//            前序第一个元素是根节点
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);

//            找中序中根节点位置
            int rootIndex = indexMap.get(rootVal);
//            左子树的节点数量
            int leftSize = rootIndex - inStart;

            root.left = build(preorder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
            return root;
        }
    }
}
