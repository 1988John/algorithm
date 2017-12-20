package easy;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/19.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,3,4,5,5};
        int[] arr = {1,1,2};

        System.out.println(removeDuplicates(arr));
    }
    /**
     *@Author: jiangwang
     *@Description: Given a sorted array, remove the duplicates in-place such that
     *  each element appear only once and return the new length.
     *@Date: 18:32 2017/12/19
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
