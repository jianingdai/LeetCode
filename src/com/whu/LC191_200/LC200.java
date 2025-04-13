package com.whu.LC191_200;

public class LC200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    // 该处是陆地
                    res += isLand(grid, r, c);
                }
            }
        }
        return res;
    }

    private int isLand(char[][] grid, int r, int c) {
        // 如果不在范围内就直接返回0
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != '1') {
            // 被遍历过（2）或者是水（1）直接返回0
            return 0;
        }
        // 将该陆地‘1’设置为遍历过‘2’
        grid[r][c] = '2';
        isLand(grid, r - 1, c);
        isLand(grid, r + 1, c);
        isLand(grid, r, c - 1);
        isLand(grid, r, c + 1);
        return 1;
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
