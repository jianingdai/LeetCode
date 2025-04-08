package com.whu.LC121_130;

public class LC121 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
//            找一下前面最小的价格，计算差值
            for (int i : prices) {
                minPrice = Math.min(minPrice, i);
                maxProfit = Math.max(i - minPrice, maxProfit);
            }
            return maxProfit;
        }
    }
}
