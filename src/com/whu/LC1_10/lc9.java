package com.whu.LC1_10;

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数
是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。
* */
public class lc9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(876));
    }

    private static class Solution {
        public boolean isPalindrome(int x) {
/*            String xStr = Integer.toString(x);
            StringBuilder sb = new StringBuilder(xStr);
            sb.reverse();
            return sb.toString().equals(xStr);*/

            String xStr = String.valueOf(x);
            for (int i = 0; i < xStr.length() / 2; i++) {
                if (xStr.charAt(i) != xStr.charAt(xStr.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
