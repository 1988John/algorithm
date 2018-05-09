package easy.number;

/**
 * Created by jiangwang on 12/20/17.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 9;
        int ways = climbStairs(n);
        int ways1 = climbStairs1(n);
        System.out.println(ways+","+ways1);
    }

    /**
     * 插空法
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int count = 0;
        for(int i=0;i<=n/2;i++){//i表示2的个数
            int num = 0;
            int left =  n-2*i;
            if(i==0 || left ==0){
                count++;
            }else if (i==1){
                num = left+1;
            }else if (left == 1){
                num = i+1;
            }
            else{
                num = 1;
                if(left >= i){
                    int a = left;
                    for(int j=1;j<=i;j++){
                        a++;
                        num *= a;
                    }
                }else{
                    int b = i;
                    for(int j=1;j<=left;j++){
                        b++;
                        num *= b;
                    }
                }
                num /=2;
            }
            count += num;
        }

        return count;
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        int memo[] = new int[n + 1];

        int count = climb_Statirs(n, memo);

        return count;
    }
    public static int climb_Statirs(int n,int[] memo){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = climb_Statirs(n-1,memo)+climb_Statirs(n-2,memo);

        return memo[n];
    }

}
