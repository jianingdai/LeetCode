package com.whu.LC231_240;


import javax.management.MBeanServer;

public class LC238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];
            int zeroNum = 0;      //0的个数
            int product = 1;        //非0的数的乘积

            // 1. 计算非0数的乘积， 以及0的个数.
            for (int num : nums) {
                if (num == 0) {
                    zeroNum++;
                } else {
                    product *= num; //计算所有的乘积
                }
            }

            // 2.  如果 0 的数量 > 1，  则所有结果都是 0。 例如： {0,0}, {0, 0, 1}. 直接return.
            if (zeroNum > 1) {
                return answer; // 都是 0
            }
            // 3.  如果有且只有一个0:  则只有一个非 0  结果， 也就是总体的乘积.
            else if (zeroNum == 1) {
                for (int i = 0; i < n; i++) {
                    if (nums[i] == 0) {  //找到 0 的位置
                        answer[i] = product;
                    }
                }
                //  return answer. 因为默认是0了， 如果不需要计算
                return answer; // 其他位置, 是 0。
            }
            // 4. 没有0: 则所有非0数字.
            else {
                for (int i = 0; i < n; i++) { //直接求值。 用总乘积 除以  nums[i].
                    answer[i] = product / nums[i]; //因为所有数字都非0,所以，可以安全的除.
                }
            }
            return answer;
        }
    }
}
