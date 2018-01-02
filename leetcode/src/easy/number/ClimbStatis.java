package easy.number;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/2.
 */
public class ClimbStatis {
    public static void main(String[] args) {

    }
    /**
     *@Author: jiangwang
     *@Description: dynamic programming
     *@Date: 11:38 2018/1/2
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
