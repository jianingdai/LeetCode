package com.whu.LC321_330;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int[] f = new int[amount+1];
        int ans =0;
        for(int i = 1;i<=amount;i++){
            int ma = Integer.MAX_VALUE-1;
            for(int j =0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    ma=Math.min(ma,f[i-coins[j]]);
                }
            }
            f[i] = ma+1;
        }
        return f[amount]==Integer.MAX_VALUE? -1:f[amount];
    }
}
