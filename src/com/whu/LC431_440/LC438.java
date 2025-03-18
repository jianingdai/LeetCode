package com.whu.LC431_440;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
//            先统计p中的字符频率
            HashMap<Character, Integer> characterFrequency = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                if (characterFrequency.get(p.charAt(i)) == null) {
                    characterFrequency.put(p.charAt(i), 1);
                } else {
                    characterFrequency.put(p.charAt(i), characterFrequency.get(p.charAt(i)) + 1);
                }
            }
//            滑动窗口进行比较
            HashMap<Character, Integer> tempHash = new HashMap<>();
            for (int i = 0; i < s.length() - p.length() + 1; i++) {
                if (i == 0) {
//                    初始化
                    for (int j = i; j < i + p.length(); j++) {
                        if (tempHash.get(s.charAt(j)) == null) {
                            tempHash.put(s.charAt(j), 1);
                        } else {
                            tempHash.put(s.charAt(j), tempHash.get(s.charAt(j)) + 1);
                        }
                    }
                } else {
//                   当滑动窗口移动后直接修改开始和结尾的就行
                    char out = s.charAt(i - 1);
                    tempHash.put(out, tempHash.get(out) - 1);
                    if (tempHash.get(out) == 0) {
                        tempHash.remove(out);
                    }
                    char a = s.charAt(i + p.length() - 1);
                    tempHash.merge(a, 1, (oldValue, newValue) -> oldValue + 1);
                }
                if (tempHash.equals(characterFrequency)) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}
