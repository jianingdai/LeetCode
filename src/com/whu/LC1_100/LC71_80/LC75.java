package com.whu.LC1_100.LC71_80;

public class LC75 {
    public void sortColors(int[] nums) {
        int n0=0,n1=0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            nums[i]=2;
            if(num<2){
                nums[n1++]=1;
            }
            if(num<1){
                nums[n0++]=0;
            }
        }
    }
}
