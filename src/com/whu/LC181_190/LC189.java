package com.whu.LC181_190;

public class LC189 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public void rotate(int[] nums, int k) {
            int[] res = new int[nums.length];
//            先对k进行除余处理
            k = k % nums.length;
            for (int i = k, j = 0; j < nums.length; i++, j++) {
                res[i % nums.length] = nums[j];
            }
            System.arraycopy(res, 0, nums, 0, res.length);
        }
    }
}
