package com.whu.LC1_100.LC11_20;

/*
给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
* */
public class lc11 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int maxArea(int[] height) {
//            return violence(height);
            return doublePointer(height);
        }

        private int doublePointer(int[] height) {
            int i = 0;//左指针
            int j = height.length - 1;//右指针
            int maxVolume = 0;//最大容量
//            由于容积是由底*高决定的
            while (i < j) {
//                高只能最低
                int high = Math.min(height[i], height[j]);
//                此时在(high,t)中是最大值,在以低边为高时,指针内敛时容积只会比这个小

//                寻求最大容积
                maxVolume = Math.max(maxVolume, high * (j - i));

//                指针向高处移动
                if (height[i] < height[j]) {
                    i = i + 1;
                } else if (height[i] > height[j]) {
                    j = j - 1;
                } else {
//                  两个边相同
                    if (height[i + 1] > height[j]) {
                        i += 1;
                    } else if (height[i] < height[j - 1]) {
                        j = j - 1;
                    } else {
//                        若内的两边比这俩都小,那么移动到一个比较高的边
                        if (height[i + 1] > height[j - 1]) {
                            i += 1;
                        } else {
                            j -= 1;
                        }
                    }
                }
            }
            return maxVolume;
        }

        private int violence(int[] height) {
            int maximumVolume = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int min = Math.min(height[i], height[j]);
                    maximumVolume = Math.max(min * (j - i), maximumVolume);
                }
            }
            return maximumVolume;
        }
    }
}
