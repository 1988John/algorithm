package easy;

import java.util.Arrays;

/**
 * http://blog.csdn.net/mimi9919/article/details/51335337
 * Created by jiangwang on 12/18/17.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        int[] result = twoSum1(num, 9);
        System.out.println(Arrays.toString(result));


    }

    /**
     * 穷举
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length<=1){
            return null;
        }else {
            for(int i=0;i<nums.length-1;i++){
                for (int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j] == target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 数组中的每个数字arr[i]都判别Sum-arr[i]是否在数组中
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length<=1){
            return null;
        }else {
            for(int i=0;i<nums.length-1;i++){
                int number = target - nums[i];
                boolean b = Arrays.asList(nums).contains(number);
                if(b){
                    result[0] = i;
                    for(int j=i;j<nums.length;j++){
                        if(nums[j] == target-nums[i]){
                            result[1] = j;
                            return result;
                        }
                    }

                }

            }
        }

        return null;
    }
}
