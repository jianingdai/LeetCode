package com.whu.LC3301_LC3310;

import java.util.HashMap;

public class LC3396 {
    public int minimumOperations(int[] nums) {
        // 检查从右向左数元素第一个相同的元素的索引
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.get(nums[i]) != null) {
                index = i;
                break;
            }
            map.put(nums[i],1);
        }
        if(index==-1){
            return 0;
        }
        int res = index/3+1;
        return res;
    }
}
