package com.whu.LC341_350;


import java.util.LinkedList;
import java.util.List;

public class LC350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new LinkedList<>();
        int[] map = new int[1001];
        for(int num : nums1){
            map[num]++;
        }
        for(int num :nums2){
            if(--map[num]>=0){
                result.add(num);
            }
        }

        return result.stream().mapToInt(num->num).toArray();
    }
}
