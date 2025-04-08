package com.whu.LC761_770;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC763 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>();
//            写一个哈希表，记录每个字符在 S 中的最后出现的位置
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                map.put(chars[i], i);
            }
            int start = 0;//记录当前字符串切片的开始下标
            int end = 0;
            for (int i = 0; i < chars.length; i++) {
                end = Math.max(map.get(chars[i]), end);
                if(end == chars.length - 1){
                    ans.add(end-start+1);
                    return ans;
                }
                if (i == end) {
                    ans.add(i - start+1);
                    start = i+1;
                }
            }
            return ans;
        }
    }
}
