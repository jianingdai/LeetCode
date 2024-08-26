package com.whu.LC11_20;
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
* */

import java.util.HashMap;
import java.util.Stack;

public class LC20 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isValid(String s) {
            HashMap<Character, Integer> hm = new HashMap<>();
            initHm(hm);
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (hm.get(s.charAt(i)) != null) {
//                    if (stack.isEmpty() && hm.get(s.charAt(i)) > 0) {
////                        当栈内空时加入一个闭符号就直接返回false
//                        return false;
//                    }
                    if (!stack.isEmpty() && hm.get(s.charAt(i)) == -hm.get(stack.peek()) && hm.get(s.charAt(i)) > 0) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            return stack.isEmpty();
        }

        private void initHm(HashMap<Character, Integer> hm) {
            hm.put('(', -1);
            hm.put(')', 1);
            hm.put('{', -2);
            hm.put('}', 2);
            hm.put('[', -3);
            hm.put(']', 3);
        }
    }
}
