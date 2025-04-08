package com.whu.LC151_160;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class LC155 {
    public static void main(String[] args) {
        MinStack solution = new MinStack();
    }

    static class MinStack {
        ArrayList<Integer> stack;
        TreeMap<Integer, Integer> map;

        public MinStack() {
            stack = new ArrayList<>();
            map = new TreeMap<>();
        }

        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            stack.add(0, val);
        }

        public void pop() {
            map.put(stack.get(0), map.get(stack.get(0)) - 1);
            if (map.get(stack.get(0)) == 0) {
                map.remove(stack.get(0));
            }
            stack.remove(0);
        }

        public int top() {
            return stack.get(0);
        }

        public int getMin() {
            return map.firstKey();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
