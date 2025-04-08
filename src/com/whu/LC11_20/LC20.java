package com.whu.LC11_20;

import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    } else if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                        stack.pop();
                    } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
