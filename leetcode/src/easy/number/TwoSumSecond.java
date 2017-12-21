package easy.number;

import java.util.Arrays;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/21.
 */
public class TwoSumSecond {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,4,9,56,90};
        int[] ints = twoSum(numbers, 8);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int value ;
        int[] resultArr = new int[2];
        for (int i=0;i<numbers.length;i++){
            value = target - numbers[i];
            int index = Arrays.binarySearch(numbers, value);
            if(index >= 0 && index != i){
                resultArr[0] = ++i;
                resultArr[1] = ++index;
                Arrays.sort(resultArr);
                return resultArr;
            }
        }
        return null;
    }
}
