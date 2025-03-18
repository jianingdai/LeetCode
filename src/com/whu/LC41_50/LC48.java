package com.whu.LC41_50;

import java.util.Arrays;

public class LC48 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public void rotate(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

//            [i,j]变成[j,i]
            for (int i = 0; i < m; i++) {
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            for (int[] row : matrix) {
                int i = 0, j = row.length - 1;
                while (i < j) {
                    int temp = row[i];
                    row[i] = row[j];
                    row[j] = temp;
                    i++;
                    j--;
                }
            }
        }
    }
}
