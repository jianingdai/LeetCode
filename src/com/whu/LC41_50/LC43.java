package com.whu.LC41_50;

public class LC43 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            int n1 = num1.length();
            int n2 = num2.length();
            int[] result = new int[n1 + n2];

//            反向遍历字符串进行乘法
            for (int i = n1 - 1; i >= 0; i--) {
                for (int j = n2 - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int sum = mul + result[i + j + 1];
//                    保证从最后一位开始向前写
                    result[i + j + 1] = sum % 10;
                    result[i + j] += sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
//                跳过前导零
                if (!(sb.isEmpty() && num == 0)) {
                    sb.append(num);
                }
            }
            return sb.toString();
        }
    }
}
