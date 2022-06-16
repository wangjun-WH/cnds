package com.example.cnds.math;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;

/**
 * @author : wangjun
 * @date : 2021/12/22  11:08
 */
public class MathTest1 {


//    public static int lengthOfLongestSubstring(String s) {
//        if (s == null || "".equals(s)) {
//            return 0;
//        }
//        int maxNum = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            sb.setLength(0);
//            //起始字符
//            sb.append(s.charAt(i));
//            int num = 1;
//            //abca
//            for (int j = i + 1; j < s.length(); j++) {
//                if (sb.indexOf(String.valueOf(s.charAt(j))) != -1) {
//                    break;
//                }
//                sb.append(s.charAt(j));
//                num++;
//            }
//            if (num > maxNum) {
//                maxNum = num;
//            }
//        }
//        return maxNum;
//    }

//    public static int lengthOfLongestSubstring(String str) {
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int start = 0;
//        int maxLength = 0;
//        for(int end = 0; end < str.length(); end++) {
//            if(map.containsKey(str.charAt(end))) {
//                start = Math.max(start, map.get(str.charAt(end)) + 1);
//            }
//            map.put(str.charAt(end), end);
//            maxLength = Math.max(maxLength, end - start + 1);
//        }
//        return maxLength;
//    }
//
//
//
//    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//    }


    //12345   -12345   -100
//    public static int reverse(int x) {
//        if (x == 0) {
//            return 0;
//        }
//        int y = x < 0 ? (0 - x) : x;
//        long[] num = new long[10];
//        //21
//        int i = 0;
//        long m = 0;
//        while (y > 0) {
//            num[i] = y % 10;
//            y = y / 10;
//            if (m == 0) {
//                m = 1;
//            } else {
//                m = m * 10;
//            }
//            i++;
//        }
//        long sum = 0;
//        for (int j = 0; j < i; j++) {
//            sum = sum + num[j] * m;
//            m = m / 10;
//        }
//        if (sum > Integer.MAX_VALUE) {
//            return 0;
//        }
//        return x < 0 ? (0 - (int) sum) : (int) sum;
//    }


    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


//2147483647

    public static void main(String[] args) {
        System.out.println(reverse(463847412));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }

























//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] != target) {
//                    continue;
//                }
//                return new int[]{i,j};
//            }
//
//        }
//        return new int[0];
//    }



//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode node1 = l1;
//        ListNode node2 = l2;
//        ListNode result = new ListNode(0);
//        ListNode preNode = result;
//        boolean plusFlag = false;
//        do {
//            int val1 = node1 == null ? 0 : node1.val;
//            int val2 = node2 == null ? 0 : node2.val;
//            int sum = val1 + val2;
//            if (plusFlag) {
//                sum = val1 + val2 + 1;
//            }
//            int val = sum;
//            if (sum > 9) {
//                plusFlag = true;
//                val = sum % 10;
//            } else {
//                plusFlag = false;
//            }
//
//            ListNode current = new ListNode(val);
//            preNode.next = current;
//            preNode = current;
//
//
//            if (node1 != null) {
//                node1 = node1.next;
//            }
//            if (node2 != null) {
//                node2 = node2.next;
//            }
//            if (sum > 9 && node1 == null && node2 == null) {
//                preNode.next = new ListNode(1);
//            }
//        } while (node1 != null || node2 != null);
//        return result.next;
//
//    }


//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int i = 0;
//        int sum1 = 0;
//        ListNode temp = l1;
//        do{
//            if (i == 0) {
//                i = 1;
//            } else {
//                i = i * 10;
//            }
//            sum1 += temp.val * i;
//            temp= temp.next;
//        }while (temp!=null);
//
//
//        i = 0;
//        int sum2 = 0;
//        temp = l2;
//        do {
//            if (i == 0) {
//                i = 1;
//            } else {
//                i = i * 10;
//            }
//            sum1 += temp.val * i;
//            temp = temp.next;
//        } while (temp != null);
//
//        int sum = sum1 + sum2;
//        int res = sum;
//        List<Integer> list = new ArrayList<>();
//        do {
//            list.add(res % 10);
//            res = res / 10;
//        }while (res>0);
//
//        ListNode temp1 = null;
//        for (int j = list.size() - 1; j >= 0; j--) {
//            temp1 = new ListNode(list.get(j), temp1);
//        }
//        return temp1;
//    }
//
//
//    public static ListNode getNode(int res) {
//        List<Integer> list = new ArrayList<>();
//        do {
//            list.add(res % 10);
//            res = res / 10;
//        } while (res > 0);
//
//        ListNode temp = null;
//        for (int j = list.size() - 1; j >= 0; j--) {
//            temp = new ListNode(list.get(j), temp);
//        }
//        return temp;
//    }


//    public static void main(String[] args) {
//        ListNode listNode = addTwoNumbers(getNode(9), getNode(99));
//        System.out.println("");
//    }


}
