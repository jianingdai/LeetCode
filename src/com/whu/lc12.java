package com.whu;

import javax.xml.transform.Result;
import java.util.HashMap;

public class lc12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3998));
    }

    private static class Solution {
        public String intToRoman(int num) {
            /*
            1 <= num <= 3999
            * */
            HashMap<Integer, String> hm = new HashMap<>();
            StringBuilder sb = new StringBuilder();

//            初始化hashmap
            hmInit(hm);
//            由于num<=3999
            int temp = num / 1000;
            for (int i = 0; i < temp; i++) {
                sb.append(hm.get(1000));
            }
            num = num % 1000;

//            处理百位
            temp = num / 100;
            function(temp, sb, hm, 100);
            num = num % 100;

//            处理十位
            temp = num / 10;
            function(temp, sb, hm, 10);
            num = num % 10;

//            处理个位
            temp = num;
            function(temp, sb, hm, 1);
            return sb.toString();
        }

        private static void function(int temp, StringBuilder sb, HashMap<Integer, String> hm, int base) {
            if (temp >= 5) {
                if (temp == 9) {
                    sb.append(hm.get(base));
                    sb.append(hm.get(10 * base));
                } else {
                    sb.append(hm.get(5 * base));
                    for (int i = 0; i < temp - 5; i++) {
                        sb.append(hm.get(base));
                    }
                }
            } else {
                if (temp == 4) {
                    sb.append(hm.get(base));
                    sb.append(hm.get(5 * base));
                } else {
                    for (int i = 0; i < temp; i++) {
                        sb.append(hm.get(base));
                    }
                }
            }
        }

        private void hmInit(HashMap<Integer, String> hm) {
            hm.put(1, "I");
            hm.put(5, "V");
            hm.put(10, "X");
            hm.put(50, "L");
            hm.put(100, "C");
            hm.put(500, "D");
            hm.put(1000, "M");
        }
    }
}
