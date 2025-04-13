package com.whu.LC1921_1930;

public class LC1922 {
    private static final int MOD = (int) 1_000_000_007;

    public int countGoodNumbers(long n) {
        return (int) (pow(5, (n + 1) / 2) * pow(4, n / 2) % MOD);
    }

    // 快速幂
    private long pow(long x, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }
}
