package com.whu;

import com.sun.management.GarbageCollectionNotificationInfo;

public class lc5 {
    public static void main(String[] args) {
        String s = "bb";
        String s1 = Solution.longestPalindrome(s);
        System.out.println(s1);
    }

    public static class Solution {
        public static String longestPalindrome(String s) {
            int len = s.length();
//            当只有一个字符的时候就是回文串
            if (len < 2) return s;

//            动态,dp[i][j]表示si ---- sj 是否是回文串
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
//                设置边界状态
                dp[i][i] = true;
            }

            char[] chars = s.toCharArray();
            int maxLen = 1;
            int begin = 0;

//            开始递推

//            先枚举字串长度
            for (int L = 2; L <= len; L++) {
//                j-i+1=L
                for (int i = 0; i <= len - L; i++) {
                    int j = L + i - 1;

//                    右边界越界直接退出
                    if (j >= len) break;


                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (L == 2) {
//                            另一个边界条件
                            dp[i][j] = true;
                        } else {
//                            当si+1~~~~sj-1不是回文的时候,si~~~sj也不会是回文
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

//                    如果是回文则记录
                    if (dp[i][j] && L > maxLen) {
                        maxLen = L;
                        begin = i;
                    }
                }
            }
//            左闭右开
            return s.substring(begin, begin + maxLen);
        }
    }
}
