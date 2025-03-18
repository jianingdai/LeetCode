package com.whu.LC131_140;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;

public class LC131 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        List<List<String>> res;

        public List<List<String>> partition(String s) {
            res = new ArrayList<>();
            dfs(s,new ArrayList<>());
            return res;
        }

        private void dfs(String s, List<String> list) {
            if (s.isEmpty()) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String temp1 = s.substring(0, i);
                String rev = new StringBuilder().append(temp1).reverse().toString();
                if (rev.equals(temp1)) {
//                    如果是回文串
                    list.add(temp1);
                    String temp2 = s.substring(i);
                    dfs(temp2, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
