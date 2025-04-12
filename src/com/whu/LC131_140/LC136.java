package com.whu.LC131_140;

public class LC136 {
    public int singleNumber(int[] nums) {
        int result =0;
        // 异或操作可以找到只出现一次的元素
        for(int num:nums){
            result = result^num;
        }
        return result;
    }
}
