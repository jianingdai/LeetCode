package com.whu.LC71_80;

public class LC79 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        private int rows, cols;
        private char[][] board;
        private String word;

        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            this.rows = board.length;
            this.cols = board[0].length;
            //遍历每一个字符
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    //从每一个字符开始深度优先搜索
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int i, int j, int index) {
            //边界检查,或者字符不匹配
            if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(index)) {
                return false;
            }
            //当最后一个字符匹配成功
            if (index == word.length() - 1) {
                return true;
            }
            //临时标记当前字符为以访问（用空格占位）
            char tmp = board[i][j];
            board[i][j] = '#';
            //递归四个方向
            boolean result = dfs(i + 1, j, index + 1) ||
                    dfs(i - 1, j, index + 1) ||
                    dfs(i, j + 1, index + 1) ||
                    dfs(i, j - 1, index + 1);
            //恢复现场
            board[i][j] = tmp;
            return result;
        }
    }
}
