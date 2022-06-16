package com.example.cnds.math;

/**
 * @author : wangjun
 * @date : 2021/12/14  14:49
 */
public class CoverToNum {
    private static int index, len;
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            PalindromeHelper(s, i, i);
            PalindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public static void PalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }



    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));


//        // TODO Auto-generated method stub
//        String s = "-12312312";
//        System.out.println("使用库函数转换：" + Integer.valueOf(s));
//        int res = CoverToNum.StrToInt(s);
//        System.out.println("使用自己写的方法转换：" + res);

    }











    public static int StrToInt(String str) {
        if (str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        // 判断是否存在符号位
        int flag = 0;
        if (chars[0] == '+')
            flag = 1;
        else if (chars[0] == '-')
            flag = 2;
        int start = flag > 0 ? 1 : 0;
        int res = 0;// 保存结果
        for (int i = start; i < chars.length; i++) {
            // 调用Character.isDigit(char)方法判断是否是数字，是返回True，否则False
            if (Character.isDigit(chars[i])) {
                int temp = chars[i] - '0';
                res = res * 10 + temp;
            } else {
                return 0;
            }
        }
        return flag != 2 ? res : -res;

    }


}
