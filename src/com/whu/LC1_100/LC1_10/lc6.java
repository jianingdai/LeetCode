package com.whu.LC1_100.LC1_10;

public class lc6 {
    //    力扣第6题
    public static void main(String[] args) {
    }

    private static class Solution {
        public String convert(String s, int numRows) {
            if (numRows < 2) return s;
            StringBuilder result = new StringBuilder();
            char[] chars = s.toCharArray();
//            创建3行stringbuilder的存储
            StringBuilder[] sbArr = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
//                进行初始化
                sbArr[i] = new StringBuilder();
            }
            int flag = -1;
            int j = 0;
//            定义一个记录当前的指针值
            for (int i = 0; i < chars.length; i++) {
                sbArr[j].append(chars[i]);
                if (j == 0 || j == numRows - 1) {
                    flag = -flag;
                }
                j += flag;
            }
            for (int i = 0; i < numRows; i++) {
                result.append(sbArr[i].toString());
            }
            return result.toString();
        }

    }
}
