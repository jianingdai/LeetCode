package com.whu.LC1_100.LC51_60;

public class LC58 {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        return ss[ss.length - 1].length();
    }
}
