package com.whu.LC131_140;

import java.util.HashMap;

public class LC138 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> oldToNew = new HashMap<>();
            Node ptr = head;
            while (ptr != null) {
//                第一次遍历先创建出新节点
                Node newNode = new Node(ptr.val);
                oldToNew.put(ptr, newNode);
                ptr = ptr.next;
            }
            ptr = head;
            while (ptr != null) {
//                第二次遍历开始串联
                Node now = oldToNew.get(ptr);
                now.random = oldToNew.get(ptr.random);
                now.next = oldToNew.get(ptr.next);
                ptr = ptr.next;
            }
            return oldToNew.get(head);
        }

        private static class Node {
            int val;
            Node next;
            Node random;

            public Node(int val) {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }
    }
}
