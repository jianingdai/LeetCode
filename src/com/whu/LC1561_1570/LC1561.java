package com.whu.LC1561_1570;

import java.util.*;

public class LC1561 {
    public int maxCoins(int[] piles) {
        // 自己写个快排
        QuickSort.quickSort(piles);
        int n = piles.length / 3;
        int res = 0;
        for (int i = 1; i < 2 * n; i += 2) {
            res += piles[i];
        }
        return res;
    }

    class QuickSort {
        public static void quickSort(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            sort(arr, 0, arr.length - 1);
        }

        private static void sort(int[] arr, int left, int right) {
            if (left >= right)
                return;
            // 随机选择基准并交换到最左侧（优化有序数组场景）[7](@ref)
            int randomIndex = left + (int) (Math.random() * (right - left + 1));
            swap(arr, left, randomIndex);
            int pivot = arr[left];
            // 初始化左右扫描指针[3,6](@ref)
            int i = left + 1, j = right;

            while (true) {
                // 左指针向右找 >=pivot 的元素[1](@ref)
                while (i <= j && arr[i] > pivot)
                    i++;
                // 右指针向左找 <=pivot 的元素[3](@ref)
                while (i <= j && arr[j] < pivot)
                    j--;
                // 指针相遇时结束扫描
                if (i >= j)
                    break;
                // 交换左右指针的不合规元素[4](@ref)
                swap(arr, i++, j--);
            }
            // 将基准归位到分割点[1](@ref)
            swap(arr, left, j);
            // 递归处理左右子区间[7](@ref)
            sort(arr, left, j - 1);
            sort(arr, j + 1, right);
        }

        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
