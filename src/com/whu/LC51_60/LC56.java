package com.whu.LC51_60;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LC56 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int[][] merge(int[][] intervals) {
//            先将双层数组内的每个数组按照start值进行增序排序，然后判断后面的一个区间的start是否在前一个区间内，
//            如果在就合并，如果不在就不进行操作
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            ArrayList<int[]> result = new ArrayList<>();
            result.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= result.get(result.size() - 1)[0] && intervals[i][0] <= result.get(result.size() - 1)[1]) {
//                    可以合并
                    int[] temp = {result.get(result.size() - 1)[0], Math.max(result.get(result.size() - 1)[1], intervals[i][1])};
                    result.remove(result.size() - 1);
                    result.add(temp);
                } else {
//                    不能合并直接加入
                    result.add(intervals[i]);
                }
            }
            return result.toArray(new int[result.size()][]);
        }

    }
}
