package com.whu.LC551_560;

import java.util.HashMap;

public class LC560 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int subarraySum(int[] nums, int k) {
//            统计前n项和,然后用哈希表查找prefixSum - k 的前n项和是否在数组中存在,而这个代表了prefixSum - (prefixSum - k ) == k
            int res = 0;
            int prefixSum = 0;
            HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
            prefixSumCount.put(0, 1);//

            for (int num : nums) {
                prefixSum += num;
                if (prefixSumCount.containsKey(prefixSum - k)) {
                    res += prefixSumCount.get(prefixSum - k);
                }
                prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
            }

            return res;
        }
    }
}
