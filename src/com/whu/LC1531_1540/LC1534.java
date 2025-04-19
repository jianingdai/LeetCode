package com.whu.LC1531_1540;

public class LC1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res=0;
        for(int k=2;k<arr.length;k++){
            for(int j=1;j<k;j++){
                for(int i=0;i<j;i++){
                    if(Math.abs(arr[i]-arr[j])<=a&&Math.abs(arr[j]-arr[k])<=b&&Math.abs(arr[i]-arr[k])<=c){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
