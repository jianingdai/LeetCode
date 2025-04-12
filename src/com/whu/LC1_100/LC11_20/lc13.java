package com.whu.LC1_100.LC11_20;

import java.util.Map;

public class lc13 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map = Map.of(
                    'I', 1,
                    'V', 5,
                    'X', 10,
                    'L', 50,
                    'C', 100,
                    'D', 500,
                    'M', 1000
            );
            int ans = 0;
            char[] chars = s.toCharArray();
            boolean flag = false;
//            MCMXCIV
            for (int i = 0; i < chars.length; ) {
                if (i != chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
//                    前大后
                    ans += map.get(chars[i + 1]) - map.get(chars[i]);
                    i += 2;
                } else {
                    ans += map.get(chars[i]);
                    i++;
                }
            }
            return ans;
        }
    }
}
