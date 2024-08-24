package com.whu.LC1_10;

/*
请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数。

函数myAtoi(string s) 的算法如下：

空格：读入字符串并丢弃无用的前导空格（' '）
符号：检查下一个字符（假设还未到字符末尾）为'-' 还是 '+'。如果两者都不存在，则假定结果为正。
转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
舍入：如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231− 1 的整数应该被舍入为 231− 1 。
返回整数作为最终结果。
* */
public class lc8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.myAtoi("20000000000000000000");
        System.out.println(i);
    }

    private static class Solution {
        public int myAtoi(String s) {
            int ans = 0;
            StringBuilder sb = new StringBuilder();
            boolean negative = false;
            char[] chars = s.toCharArray();
//            全局指针
            int i = 0;
            for (; i < chars.length; i++) {
//                跳过前导空格
                if (chars[i] == ' ') continue;
                break;
            }
//           先检查指针位置
            if (i >= chars.length) {
                return ans;
            }
//            检查符号
            if (chars[i] == '-') {
//                    记录负数标记
                negative = true;
                i++;
            } else if (chars[i] == '+') {
                i++;
            }
            for (; i < chars.length; i++) {
                if (!this.isNum(chars[i])) {
//                    如果遇到了非数字就跳出返回
                    break;
                }
//                检查前导零
                if (chars[i] != '0') {
                    break;
                }
            }
            for (; i < chars.length; i++) {
                if (!this.isNum(chars[i])) {
                    break;
                }
                sb.append(chars[i]);
            }
            if (sb.isEmpty()) {
                return ans;
            }
            ans = getAnInt(sb, negative);
            return ans;
        }

        private static int getAnInt(StringBuilder sb, boolean negative) {
            int ans;
            long num = 0;
            try {
                num = Integer.parseInt(sb.toString());
            } catch (NumberFormatException e) {
                if (negative) {
                    ans = 0x80000000;
                } else {
                    ans = 0x7fffffff;
                }
                return ans;
            }
            if (negative) {
                num = -num;
            }
            ans = (int) num;

            return ans;
        }

        private boolean isNum(char c) {
            if (c >= '0' && c <= '9') {
                return true;
            }
            return false;
        }
    }
}
