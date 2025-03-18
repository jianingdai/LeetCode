package com.whu.LC51_60;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return result;
            }
            int m = matrix.length;//行数
            int n = matrix[0].length;//列数

//            设定边界
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = m - 1;

            while (left <= right && top <= bottom) {
//                从左到右
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;//上边界下移

//                从上倒下
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

//                从左到右
                if (top <= bottom) {//避免重复遍历
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;//下边界上移
                }

//                从下到上
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                }
                left++;//左边界右移
            }
            return result;
        }
    }
}
