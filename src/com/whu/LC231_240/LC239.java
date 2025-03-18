package com.whu.LC231_240;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class LC239 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }

            int ansSize = nums.length - k + 1;
            int[] result = new int[ansSize];
            int point = 0;

            ArrayDeque<Integer> deque = new ArrayDeque<>();
//            初始化窗口，单调队列
            for (int i = 0; i < nums.length; i++) {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                    deque.removeLast();
                }
                deque.add(i);

//                当窗口形成后开始记录最大值
                if (i >= k - 1) {
//                    记录最大值
                    if (!deque.isEmpty()) {
                        if (deque.peekFirst() <= i - k) {
                            deque.removeFirst();//如果最大值已经超出了窗口那么就移除出去
                        }
                        if (!deque.isEmpty())
                            result[point++] = nums[deque.peekFirst()];
                    }
                }
            }
            return result;

        }
    }
}
