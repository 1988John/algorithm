package easy.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/3.
 */
public class NumArray {
    private int[] data;
    private int[][] sum;

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(2,5);
        System.out.println(param_1);
    }
    public NumArray(int[] nums) {
        data = nums;
        sum = new int[data.length][data.length];
    }

    public int sumRange(int i, int j) {
        sum[i][i] = data[i];
        int head=(j-i)/2+1;
        int tail = head+1;
        while(head !=i || tail !=j){

            if (head>=i && tail<=j)
                sum[head][tail] = data[head]+sum[head--][tail++]+data[tail];
            else if (tail<=j)
                sum[head][tail] = sum[head][tail++]+data[tail];
            else
                sum[head][tail] = data[head]+sum[head--][tail];

        }
        return sum[i][j];
    }
}
