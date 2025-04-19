package com.whu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
//        m代表有几个测试用例，n代表有几个代码模块
        int i = sc.nextInt();
        int j = sc.nextInt();
//        cases为输入的测试图
        List<Integer> cases = new ArrayList<>();
        int requiredMask = (1 << j) - 1;
        for (int n = 0; n < i; n++) {
            int mask = 0;
            for (int k = 0; k < j; k++) {
                int val = sc.nextInt();
                if (val == 1) {
                    mask |= (1 << k);
                }
            }
            cases.add(mask);
        }

//        检查所有模块都被覆盖？
        int allCovered = 0;
        for (int mask : cases) {
            allCovered |= mask;
        }
        if ((allCovered & requiredMask) != requiredMask) {
            System.out.println(-1);
            return;
        }
        int uncovered = requiredMask;
        int selected = 0;
        while (uncovered != 0) {
            int maxCover = -1;
            int bestMask = 0;
            for (int mask : cases) {
//                有效覆盖数
                int currentCover = Integer.bitCount(mask & uncovered);
                if (currentCover > maxCover) {
                    maxCover = currentCover;
                    bestMask = mask;
                }
            }
//            if (maxCover == 0) {
//                System.out.println(-1);
//                return;
//            }
            selected++;
            uncovered &= ~bestMask;
        }
        System.out.println(selected);
    }
}
