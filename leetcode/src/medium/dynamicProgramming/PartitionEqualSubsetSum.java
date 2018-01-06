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
            count /= 2;
            boolean[][] dp = new boolean[nums.length][count+1];
            dp[0][0] = false;
            for(int i=0;i<=count;i++){
                dp[0][i] = false;
            }
            if(nums[0]<= count){
                dp[0][nums[0]] = true;
            }
            for(int i=1;i<nums.length;i++){
                for(int j=0;j<count;j++){
                    if(j>=nums[i]){
                        dp[i][j] = dp[i-1][j-1] || dp[i-1][j-nums[i]];
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                if(dp[i][count])
                    return true;
            }
        }
        return false;
    }
}
