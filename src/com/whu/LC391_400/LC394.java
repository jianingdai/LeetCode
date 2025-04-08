package com.whu.LC391_400;

import java.util.Stack;

public class LC394 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>(); // 栈，用于存储数字和字符串片段 (Object 类型，因为要同时存数字和字符串)
            StringBuilder resBuilder = new StringBuilder(); // 当前正在构建的字符串片段，使用 StringBuilder 提高效率
            int num = 0; // 当前解析到的数字

            for (char charVal : s.toCharArray()) {
                if (Character.isDigit(charVal)) {
                    // 如果是数字，累积数字 (可能有多位数)
                    num = num * 10 + Character.getNumericValue(charVal);
                } else if (Character.isLetter(charVal)) {
                    // 如果是字母，追加到当前字符串片段
                    resBuilder.append(charVal);
                } else if (charVal == '[') {
                    // 遇到 '['，将当前数字和字符串片段入栈
                    stack.push(resBuilder.toString()); // 保存之前的字符串片段 (需要转成 String)
                    stack.push(num);                  // 保存重复次数
                    resBuilder = new StringBuilder(); // 重置当前字符串片段，开始解析括号内的内容
                    num = 0;                          // 重置数字
                } else if (charVal == ']') {
                    // 遇到 ']'，开始解码
                    int repeatTimes = (int) stack.pop(); // 取出重复次数 (需要强制类型转换成 int)
                    String prevString = (String) stack.pop(); // 取出之前的字符串片段 (需要强制类型转换成 String)
                    StringBuilder decodedString = new StringBuilder(prevString); // 使用 StringBuilder 构建解码后的字符串
                    for (int i = 0; i < repeatTimes; i++) {
                        decodedString.append(resBuilder); // 将括号内的解码结果重复指定次数后，拼接到之前的片段上
                    }
                    resBuilder = decodedString; // 更新当前字符串片段为解码后的结果
                } else {
                    // 理论上不应该出现其他字符，题目保证输入有效
                    // 可以选择抛出异常或者忽略
                }
            }

            return resBuilder.toString(); // 最终的解码结果 (需要转成 String)
        }
    }
}

