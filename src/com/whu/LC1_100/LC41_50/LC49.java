package com.whu.LC1_100.LC41_50;

import java.util.*;

public class LC49 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String newStr = new String(chars);
                if (!map.containsKey(newStr)) {
//                    第一次出现这个异构
                    List<String> subAns = new ArrayList<>();
                    subAns.add(strs[i]);
                    ans.add(subAns);
                    map.put(newStr, ans.size() - 1);
                } else {
//                    不是第一次出现这个异构
                    ans.get(map.get(newStr)).add(strs[i]);
                }
            }
            return ans;
        }
    }
}
