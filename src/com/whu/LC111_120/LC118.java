package com.whu.LC111_120;

import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
//            第一行比较特殊独自加入
            List<Integer> first = new ArrayList<>();
            first.add(1);
            res.add(first);


            for (int i = 1; i < numRows; i++) {
//                构建第i行的链表
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for (int j = 1; j < i+1; j++) {
//                    j记录的是该行的第j个数字

                    if (j == i) {
                        list.add(1);
                        res.add(list);
                    } else {
//                    1.处理第j个数字
                        list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                    }
                }
            }
            return res;
        }
    }
}
