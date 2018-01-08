package medium.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/8.
 */
public class RangeSumQueryImmutable {
    private int[] data ;
    private int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        data = nums;
        sum = new int[data.length];

        if(data != null && data.length>0){
            sum[0] = data[0];
            for(int start=1;start<data.length;start++){
                int temp = start;
                sum[start] = sum[temp-1] + data[start];
            }
        }

    }

    public int sumRange(int i, int j) {

        return  i==0?sum[j]:sum[j]-sum[i-1];

    }

    public static void main(String[] args) {
        int[] data1 = {-2,0,3,-5,2,-1};
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(data1);
        int count = r.sumRange(0, 2);
        System.out.println(count);
    }
}
