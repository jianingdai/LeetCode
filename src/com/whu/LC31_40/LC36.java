package com.whu.LC31_40;

public class LC36 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] box = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    } else {
                        int num = board[i][j] - '1';
                        int rowNum = i;
                        int colNum = j;
//                        !!!
                        int boxNum = i / 3*3 + j / 3;

                        if (row[rowNum][num] || col[colNum][num] || box[boxNum][num]) {
                            return false;
                        } else {
                            row[rowNum][num] = true;
                            col[colNum][num] = true;
                            box[boxNum][num] = true;
                        }
                    }
                }
            }
            return true;
        }
    }
}
