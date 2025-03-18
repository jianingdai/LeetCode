package com.whu.LC141_150;

import java.util.HashMap;
import java.util.Map;

public class LC146 {
    public static void main(String[] args) {
        LRUCache solution = new LRUCache(1);
    }

    static class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode dummyHead, dummyTail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
//            使用伪头部和伪尾部节点
            dummyHead = new DLinkedNode();
            dummyTail = new DLinkedNode();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            moveToHead(node);
            return node.value;
        }


        private void moveToHead(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToHead(node);
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                DLinkedNode newNode = new DLinkedNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private DLinkedNode removeTail() {
            DLinkedNode node = dummyTail.prev;
            dummyTail.prev.prev.next = dummyTail;
            dummyTail.prev = dummyTail.prev.prev;
            node.next = null;
            node.prev = null;
            return node;
        }

        private void addToHead(DLinkedNode newNode) {
            newNode.next = dummyHead.next;
            newNode.prev = dummyHead;
            dummyHead.next = newNode;
            newNode.next.prev = newNode;
        }
    }
}
