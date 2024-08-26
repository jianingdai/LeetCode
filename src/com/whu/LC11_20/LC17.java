package com.whu.LC11_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
* */
public class LC17 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<String> letterCombinations(String digits) {
//            0 <= digits.length <= 4
            if (digits == null || digits.isEmpty()) {
                return new ArrayList<>();
            }
            HashMap<Character, String> hm = new HashMap<>();
            initHm(hm);
            List<String> res = new ArrayList<>();
            backtracking(res, hm, digits, 0, new StringBuffer());
            return res;
        }

        /**
         * @param res    最终返回的链表
         * @param hm     查询用的表
         * @param digits 数字
         * @param index  目前要处理的数字
         * @param sb     传来的单子串
         */
        private void backtracking(List<String> res, HashMap<Character, String> hm, String digits, int index, StringBuffer sb) {
            if (index == digits.length()) {
//                当从根到叶遍历完了
                res.add(sb.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = hm.get(digit);
                int letterCount = letters.length();
                for (int i = 0; i < letterCount; i++) {
//                    给sb的末尾添加字符
                    sb.append(letters.charAt(i));
                    backtracking(res, hm, digits, index + 1, sb);
//                    每遍历完一个枝干都删除清空sb的缓冲区
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        private void initHm(HashMap<Character, String> hm) {
            hm.put('2', "abc");
            hm.put('3', "def");
            hm.put('4', "ghi");
            hm.put('5', "jkl");
            hm.put('6', "mno");
            hm.put('7', "pqrs");
            hm.put('8', "tuv");
            hm.put('9', "wxyz");
        }
    }
}
