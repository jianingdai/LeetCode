package com.whu.LC1_100.LC71_80;

public class LC74 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int left = 0;
            int right = m - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (right < 0) {
                return false;
            }

            int row = right;
            left = 0;
            right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[row][mid] == target) {
                    return true;
                } else if (matrix[row][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return false;
        }
    }
}