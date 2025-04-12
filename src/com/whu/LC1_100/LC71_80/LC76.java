package com.whu.LC1_100.LC71_80;

import java.util.HashMap;

public class LC76 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public String minWindow(String s, String t) {
//            先建立一个字典记录需要的字符频率
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
//            滑动窗口左右指针
            int left = 0, right = 0, valid = 0;
//            记录字符串的信息
            int start = 0;
            int length = Integer.MAX_VALUE;
//            滑动窗口内字符统计
            HashMap<Character, Integer> window = new HashMap<>();

//            滑动窗口右移
            for (; right < s.length(); right++) {
//                把向右扩展的字符加入到窗口中
                char c = s.charAt(right);
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c) != null && window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }

//                    此时所有的t字符满足要求
                while (valid == need.size()) {
//                        只有在t字符都满足要求时才进行缩小窗口操作
                    if (right - left < length) {
                        start = left;
                        length = right - left + 1;
                    }
                    char temp = s.charAt(left);
                    if (need.containsKey(temp)) {  // 说明当前移除的 temp,是t字符.  需要进行进一步判断.
                        //此时 说明要移除该t里面的一个字符,对状态产生了影响.
                        if (window.get(temp).intValue() == need.get(temp).intValue()) {
                            valid--;   // 这个被移除了， 就达不到需求了, 所以valid--;
                        }
                        window.put(temp, window.get(temp) - 1); // 更新 window 中的该字符的 数量
                    }
                    left++;
                }
            }
            if (length != Integer.MAX_VALUE) {
                return s.substring(start, start + length);
            } else {
                return "";
            }
        }
    }
}
