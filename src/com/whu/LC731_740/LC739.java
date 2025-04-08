package com.whu.LC731_740;

import java.util.Map;
import java.util.Stack;

class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 维护一个单调递减的栈
        int[] res = new int[temperatures.length];
        Stack<kv> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().getTemperatures() < temperatures[i]) {
                int index=stack.pop().getIndex();
                res[index] = i-index;
            }
            stack.push(new kv(temperatures[i], i));
        }
        return res;
    }

    class kv{
        private Integer temperatures;
        private Integer index;
        public kv(Integer temperatures, Integer index) {
            this.temperatures = temperatures;
            this.index = index;
        }
        public int getTemperatures(){
            return temperatures;
        }
        public int getIndex(){
            return index;
        }
    }
}