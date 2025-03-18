package com.whu.LC41_50;

public class LC42 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int trap(int[] height) {
            int length = height.length;

//        先初始化两个数组leftMax和rightMax来分别表示在某个坐标处的左面和右面的最大值
            int[] leftMax = new int[length];
            leftMax[0] = 0;
            int[] rightMax = new int[length];
            rightMax[length - 1] = 0;
            for (int i = 1; i < length; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }
            for (int i = length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }
//        计算每个位置可以容纳的水量并且累加,最左面和最右面肯定不能积水
            int sumWater = 0;
            for (int i = 0; i < length; i++) {
                int RLMin = Math.min(leftMax[i], rightMax[i]);
                int water = RLMin > height[i] ? RLMin - height[i] : 0;
                sumWater += water;
            }
            return sumWater;
        }
    }
}
