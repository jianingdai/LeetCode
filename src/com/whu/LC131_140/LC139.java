package com.whu.LC131_140;

import java.util.List;

public class LC139 {
    // 材料：字典中的单词，可以无限使用
    // 背包为s时，是否可以把背包装满？
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[j]表示背包为s.substring(0,j)时，能否把背包装满
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int j=1;j<=s.length();j++){
            for (String string : wordDict) {
                // 从wordDict[0,...,i]中取
                if (!dp[j]) {
                    if (j >= string.length()) {
                        dp[j] = dp[j - string.length()] && s.startsWith(string, j - string.length());
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
