package com.whu.LC121_130;

import com.whu.AAA;

import java.time.chrono.MinguoChronology;
import java.util.HashMap;

public class LC128 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0, -1}));
    }

    private static class Solution {
        public int longestConsecutive(int[] nums) {
//            复杂度要O(n)
//            先建立hashmap补全
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int maxLen = 0;
            for (int num : nums) {
                if (map.containsKey(num - 1)) {
//                    直接跳过该num
                    continue;
                }
//                num被保证是一个序列的起始节点
                int maxLenSub = 1;
                for (int i = 1; i < nums.length; i++) {
//                    一直查找直到找到不连续的序列然后跳出
                    if (map.get(num + i) == null) {
                        maxLen = Math.max(maxLen, maxLenSub);
                        break;
                    }
                    maxLenSub++;
                    maxLen = Math.max(maxLen, maxLenSub);
                }
            }
            return maxLen;
        }
    }
}
