package com.whu.LC1_100.LC1_10;

import java.util.HashMap;

/*
给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。
* */
public class LC3 {
    public static void main(String[] args) {
//
        String s = "abba";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
//          记录以每个字符串结尾的最长不重复的子串
//          abcabcbb    pwwkew
//          12332311    121

//            在遍历的同时加载一个hashmap记录每个符号出现的最大的序号
            int start = 0, end = 0;
            int ans = 0;

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
//                    这是一个新出现的字符
                    end = i;
                    ans = Math.max(ans, end - start + 1);
                    map.put(s.charAt(i), i);
                } else {
//                    这个字符在之前出现过
                    if (map.get(s.charAt(i)) < start) {
                        end = i;
                        ans = Math.max(ans, end - start + 1);
                        map.put(s.charAt(i), i);
                    } else {
//                    移动start的指针
                        start = 1 + map.get(s.charAt(i));
                        end = i;
                        ans = Math.max(ans, end - start + 1);
                        map.put(s.charAt(i), i);
                    }
                }
            }
            return ans;
        }
    }
}
