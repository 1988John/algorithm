package easy.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/2.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,1,1,1};
        int re = rob(nums);
        System.out.println(re);
    }
    public static int rob(int[] nums) {
        if(nums == null || nums.length==0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return nums[0] >= nums[1] ? nums[0] : nums[1];
        }
        int[] amount = new int[nums.length];
        amount[0] = nums[0];
        amount[1] = nums[0] >= nums[1] ? nums[0] : nums[1];
        for(int i=2;i<nums.length;i++){
            amount[i] =  amount[i-1] >= (amount[i-2]+nums[i]) ? amount[i-1] : (amount[i-2]+nums[i]);
        }


        return amount[amount.length-1];
    }
}
