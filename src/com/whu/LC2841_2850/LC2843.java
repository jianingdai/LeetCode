package com.whu.LC2841_2850;

public class LC2843 {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = low;i<=high;){
            String str = Integer.toString(i);
            if(str.length()%2!=0){
                // 非2n
                i=(int)Math.pow(10,str.length());
                continue;
            }
            int half =0;
            int second_half = 0;
            for(int j =0;j<str.length();j++){
                if(j<str.length()/2){
                    half+=str.charAt(j)-'0';
                }else{
                    second_half+=str.charAt(j)-'0';
                }
            }
            if(half==second_half){
                res++;
            }
            i++;
        }
        return res;
    }
}
