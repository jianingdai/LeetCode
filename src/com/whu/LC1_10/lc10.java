package com.whu.LC1_10;

/*
给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s 的，而不是部分字符串。
* */
public class lc10 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", ".*"));
    }

    private static class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

//            初始化
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;

            for (int i = 1; i <= n; i++) {
                if (p.charAt(i - 1) == '*') {
//                    while i-1!=0,i>1->i>=2
//                    i-2>=0
                    dp[0][i] = dp[0][i - 2];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                            dp[i][j] = dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
