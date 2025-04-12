package com.whu.LC1_100.LC31_40;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC32 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    private static class Solution {
        public int longestValidParentheses(String s) {

            if (s == null || s.isEmpty()) return 0;
//            建立新的数据结构aS(associatedSymbols)其中包括符号的index和符号本身
//         维护一个栈,将所有的数据结构进栈走完一遍,留在栈中的数据就是字符串中的不能被匹配的所有元素,计算所有被不能匹配的元素的间隔开的间隔大小返回最大间隔

            List<aS> aSL = new ArrayList<aS>();//associatedSymbolsList
//            对字符串进行处理转换成aS类型并且串成一个列表
            for (int i = 0; i < s.length(); i++) {
                aSL.add(new aS(s.charAt(i), i));
            }
//            维护一个栈
            Stack<aS> aSST = new Stack<aS>();//associatedSymbolsStack
            for (aS as : aSL) {
                if (!aSST.isEmpty()) {
//                    当栈非空则先匹配
                    if (aSST.peek().c == '(' && as.c == ')') {
//                        匹配成功出栈
                        aSST.pop();
                    } else {
//                        匹配失败则留栈
                        aSST.push(as);
                    }
                } else {
//                    当栈空时
                    aSST.push(as);
                }
            }

//            用于存储间隔的最大值
            int res = 0xffffffff;
//            flag用来求最后一个间隔的大小
            boolean flag = false;
            while (!aSST.isEmpty()) {
                if (!flag) {
                    flag = true;
                    aS pop = aSST.pop();
//                    第一个元素先和右边界比较
                    res = Math.max(res, s.length() - 1 - pop.index);
//                    再和栈内左元素比较(如果有的话)
                    if (!aSST.isEmpty()) {
                        res = Math.max(res, pop.index - 1 - aSST.peek().index);
                    } else {
                        //如果栈内没有元素的话再检查一下左边界(字符串中有且只有一个不能匹配的括号)
                        res = Math.max(res, pop.index);
                    }
                } else {
//                    标准流程
                    aS pop = aSST.pop();
                    if (aSST.isEmpty()) {
//                        此时弹出了最后一个aS
                        res = Math.max(res, pop.index);
                    } else {
                        res = Math.max(res, pop.index - 1 - aSST.peek().index);
                    }
                }
            }
            if (res == -1) {
                return s.length();
            }
            return res;
        }

        public static class aS {
            private char c;
            int index;

            public aS() {
            }

            public aS(char c, int index) {
                this.c = c;
                this.index = index;
            }

            /**
             * 获取
             *
             * @return c
             */
            public char getC() {
                return c;
            }

            /**
             * 设置
             *
             * @param c 字符
             */
            public void setC(char c) {
                this.c = c;
            }

            /**
             * 获取
             *
             * @return index
             */
            public int getIndex() {
                return index;
            }

            /**
             * 设置
             *
             * @param index 字符在字符串中的序号
             */
            public void setIndex(int index) {
                this.index = index;
            }

            public String toString() {
                return "aS{c = " + c + ", index = " + index + "}";
            }
        }
    }

}
