package com.whu.LC1_100.LC41_50;

public class LC50 {
    public double myPow(double x, int n) {
        double ans = 1;
        long lN = n;
        if (lN < 0) {
            x = 1 / x;
            lN = -lN;
        }
        while (lN != 0) {
            if ((lN & 1) == 1) {
                ans *= x;
            }
            x *= x;
            lN >>= 1;
        }
        return ans;
    }
}
