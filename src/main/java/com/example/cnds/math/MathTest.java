package com.example.cnds.math;

/**
 * @author : wangjun
 * @date : 2021/11/26  17:57
 */
public class MathTest {


    public static void main(String[] args) {
        int[] nums={1,3,4,6,7,9,14,2,22};
        rob(nums);
    }


    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额

        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }

        int N = nums.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
        }
        System.out.println(dp[N]);
        return dp[N];
    }
}
