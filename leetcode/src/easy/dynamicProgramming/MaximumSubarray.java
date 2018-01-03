package easy.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/2.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
    public static int maxSubArray(int[] nums) {
        int[] count = new int[nums.length];
        count[0] = nums[0];
        int start = nums[0];
        for(int i=1;i<nums.length;i++){
            if(start<0){
                start = 0;
            }
            count[i] = count[i-1] > start+nums[i] ? count[i-1] : start+nums[i];
            start += nums[i];

        }
        return count[count.length-1];
    }
}
