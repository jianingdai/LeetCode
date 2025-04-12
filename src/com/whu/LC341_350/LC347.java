package com.whu.LC341_350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // key:元素
        // value:出现频次
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> orderList = hashMap.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .toList();
        for (int i = 0; i < k; i++) {
            result[i] = orderList.get(i).getKey();
        }
        return result;
    }
}
