package com.whu.LC1_100.LC71_80;

import java.util.Arrays;
import java.util.HashSet;

public class LC73 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public void setZeroes(int[][] matrix) {
            HashSet<Integer> zeroRow = new HashSet<>();
            HashSet<Integer> zeroColumn = new HashSet<>();

            int m = matrix.length;//m行
            int n = matrix[0].length;//n列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRow.add(i);
                        zeroColumn.add(j);
                    }
                }
            }
            for (int row : zeroRow) {
                Arrays.fill(matrix[row], 0);
            }
            for (int column : zeroColumn) {
                for (int i = 0; i < m; i++) {
                    matrix[i][column] = 0;
                }
            }
        }
    }
}
