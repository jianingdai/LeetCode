package com.whu.LC31_40;

public class LC38 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countAndSay(2);
    }

    private static class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);
                int count = 0;
                while (i < s.length() && s.charAt(i) == c) {
//                    sb.append(c);
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
