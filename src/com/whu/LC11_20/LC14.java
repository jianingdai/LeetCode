package com.whu.LC11_20;

public class LC14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            int minLength = Integer.MAX_VALUE;
            for (String str : strs) {
                if (str.length() < minLength) {
                    minLength = str.length();
                }
            }
            boolean flag = true;
            for (int i = 0; i < minLength; i++) {
                if (!flag) {
                    break;
                }
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != strs[0].charAt(i)) {
                        flag = false;
                    }
                }
                if (flag) {
                    sb.append(strs[0].charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
