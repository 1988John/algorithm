package easy.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/3.
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {0,1,1,1};
        int[] cost1 = {0,1,2,2};
        int result = minCostClimbingStairs(cost);
        System.out.println(result);

        int result1 = minCostClimbingStairs(cost1);
        System.out.println(result1);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] count = new int[cost.length];
        count[0] = 0;
        count[1] = cost[0] > cost[1] ? cost[1] : cost[0];

        for(int i=2;i<cost.length;i++){
           count[i] =  count[i-1]+cost[i] > count[i-2] + cost[i-1] ? count[i-2]+cost[i-1] : count[i-1] + cost[i];
        }
        return count[count.length-1];
    }
}
