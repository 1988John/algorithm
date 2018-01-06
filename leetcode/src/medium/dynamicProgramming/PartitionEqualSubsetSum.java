package medium.dynamicProgramming;

/**
 * Description:  416
 * Created by jiangwang3 on 2018/1/5.
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        boolean result = canPartition(nums);
        System.out.println(result);
    }
    /**
     *@Author: jiangwang
     *@Description:
     *@Date: 15:09 2018/1/5
     */
    public static boolean canPartition(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += nums[i];
        }
        if(count%2 == 0) {
            int half = count/2;
            int[][] dp = new int[nums.length][half];
            dp[0][half] = nums[0];
            int result ;
            for(int i=1;i<nums.length;i++){
                for(int j=0;j<half;j++){
                    dp[i][j] = dp[i][j-1];
                }
//               result = dp[i-1] + nums[i];
//               if(result == count/2)
//                   return true;
//               else if (result < count/2)
//                       dp[i] = result;
//               else dp[i] = dp[i-1];
            }
        }
        return false;
    }
}
