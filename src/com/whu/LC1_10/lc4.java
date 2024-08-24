package com.whu.LC1_10;

import java.util.ArrayList;
import java.util.Arrays;

public class lc4 {
    //            返回nums1和nums2合并后的数组中的中位数
    public static void main(String[] args) {
        int[] num1 = {1};
        int[] num2 = {1};
        System.out.println(Solution.findMedianSortedArrays1(num1, num2));
    }

    public static class Solution {
        public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
            double ans = 0.0;
//            分成两种情况:总元素量为奇数,总元素量为偶数
//            奇数直接找序号为n/2的元素,偶数找n/2-1 , n/2             O(m+n)
            if (nums1.length > nums2.length) {
//                nums1为比较短的数组
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }

            int m = nums1.length;
            int n = nums2.length;
            int len = m + n;
            int i = 0, j = 0;
            ArrayList<Integer> num3 = new ArrayList<>();

            while (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    num3.add(nums1[i]);
                    i++;
                } else {
                    num3.add(nums2[j]);
                    j++;
                }
                if (num3.size() == (len / 2 + 1)) {
//                    当可以直接计算
                    if (len % 2 == 0) {
                        ans = 1.0 * (num3.get(num3.size() - 2) + num3.get(num3.size() - 1)) / 2;
                        return ans;
                    } else {
                        return 1.0 * num3.get(num3.size() - 1);
                    }
                }
            }
//            若此时则一个或者第二个已经遍历结束
            if(j==n){
                for (int k = i; k < m; k++) {
                    num3.add(nums1[k]);
                    if (num3.size() == (len / 2 + 1)) {
                        if (len % 2 == 0) {
                            ans = 1.0 * (num3.get(num3.size() - 2) + num3.get(num3.size() - 1)) / 2;
                            return ans;
                        } else {
                            return 1.0 * num3.get(num3.size() - 1);
                        }
                    }
                }
            }else{
                for (int k = j; k < n; k++) {
                    num3.add(nums2[k]);
                    if (num3.size() == (len / 2 + 1)) {
                        if (len % 2 == 0) {
                            ans = 1.0 * (num3.get(num3.size() - 2) + num3.get(num3.size() - 1)) / 2;
                            return ans;
                        } else {
                            return 1.0 * num3.get(num3.size() - 1);
                        }
                    }
                }
            }
            return ans;
        }

        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
//            O(nlogn)
            double ans = 0.0;
            int[] num3 = new int[nums1.length + nums2.length];
            for (int i = 0; i < nums1.length; i++) {
                num3[i] = nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                num3[nums1.length + i] = nums2[i];
            }
            int[] array = Arrays.stream(num3).sorted().toArray();
            int index = (array.length + 1) / 2;
            ans = array.length % 2 == 0 ? 1.0 * (array[index] + array[index - 1]) / 2 : (double) array[index - 1];
            return ans;
        }
    }
}
