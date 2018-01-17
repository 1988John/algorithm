package medium.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/17.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] obs = {{1,3,1},{1,5,1},{4,2,1}};
        int i = minPathSum(obs);
        System.out.println(i);
    }

    public static int minPathSum(int[][] grid) {

        int dLength = grid.length;
        int rLength = grid[0].length;
        int[][] sum = new int[dLength][rLength];

        sum[0][0] = grid[0][0];
        for(int i=1;i<rLength;i++){
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }

        for(int i=1;i<dLength;i++){
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for (int i=1;i<dLength;i++){
            for (int j=1;j<rLength;j++){
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[dLength-1][rLength-1];
    }
}
