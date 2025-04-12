package com.whu.LC3371_3380;

public class LC3375 {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        int[] map = new int[101];
        for (int i : nums) {
            if (i < k) {
                return -1;
            }
            if (i > k && map[i] == 0) {
                res++;
                map[i] = 1;
            }
        }
        return res;
    }
}
