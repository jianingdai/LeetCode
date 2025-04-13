package com.whu.LC991_1000;

import java.util.Arrays;

public class LC994 {
    int m;
    int n;
    private final int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] time = new int[m][n];
        // 初始化时间矩阵
        for (int i = 0; i < m; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    // 从腐烂的橘子开始进行深度优先搜索
                    // 多源dfs
                    dfs(grid, r, c, time, 0);
                }
            }
        }

        // 统计时间
        int maxTime = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) { // 只关心原始新鲜的橘子
                    if (time[r][c] == Integer.MAX_VALUE) {
                        // 还有新鲜橘子
                        return -1;
                    }
                    maxTime = Math.max(maxTime, time[r][c]);
                }
            }
        }
        return maxTime;
    }

    private void dfs(int[][] grid, int r, int c, int[][] time, int currentTime) {
        if (!isLegal(r, c)) {
            // 在图外面直接返回
            return;
        }
        if (currentTime >= time[r][c])
            return;
        time[r][c] = currentTime;

        // 向四个方向递归处理新鲜橘子
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            // 仅处理相邻的新鲜橘子（不修改原数组）
            if (isLegal(nr, nc) && grid[nr][nc] == 1) {
                dfs(grid, nr, nc, time, currentTime + 1);
            }
        }
    }

    private boolean isLegal(int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n;
    }
}
