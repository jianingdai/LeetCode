package com.whu.LC231_240;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class LC240 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;//行
            int n = matrix[0].length;//列

//            从右上角开始
            for (int i = 0; i < Math.min(m, n); i++) {
                if (target == matrix[i][n - 1 - i]) {
//                    对角线上等于的话直接返回
                    return true;
                } else if (target > matrix[i][n - 1 - i]) {
                    for (int j = i + 1; j < m; j++) {
//                        可以二分优化
                        if (target == matrix[j][n - 1 - i]) {
                            return true;
                        }
                    }
                } else {
                    for (int j = n - 1 - i; j >= 0; j--) {
//                        可以二分优化
                        if (target == matrix[i][j]) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
