package com.whu.LC21_30;
/*
数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
* */

import java.util.*;

public class LC22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(2));
    }

    private static class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n <= 0) return null;

            def(new StringBuilder(), 0, 0, n);

            return res;
        }

        public void def(StringBuilder paths, int left, int right, int n) {
//            left是左括号的数目,right是右括号的数目
            if (left > n || right > left) return;
            if (paths.length() == n * 2) {
                res.add(paths.toString());
                return;
            }
            def(new StringBuilder(paths).append("("), left + 1, right, n);
            def(new StringBuilder(paths).append(")"), left, right + 1, n);
        }
    }
}
