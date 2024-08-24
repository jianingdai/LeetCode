package com.whu.LC1_10;

/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
* */
public class lc7 {
    public static void main(String[] args) {
        int x = 1_534_236_469;
        System.out.println(Solution.reverse(x));
    }

    private static class Solution {
        public static int reverse(int x) {
            long ans = 0L;
            if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
                return 0;
            }
            boolean negative = false;
            if (x < 0) {
                x = Math.abs(x);
                negative = true;
            }
            String str = Integer.toString(x);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();

            if (negative) {
                sb.insert(0, '-');
            }
            ans = Long.parseLong(sb.toString());
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) ans;
        }
    }
}
