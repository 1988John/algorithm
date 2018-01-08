package medium.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/8.
 */
public class UniquePaths {
    public static void main(String[] args) {
        int paths = uniquePaths(1, 2);
        System.out.println(paths);
    }
    public static int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            paths[i][0] = 0;
            paths[i][1] = 1;
        }
        for(int i=0;i<=n;i++){
            paths[0][i] = 0;
            paths[1][i] = 1;
        }
        paths[0][1] = 0;
        paths[1][0] = 0;

        for(int i=2;i<=m;i++){
            for (int j=2;j<=n;j++){
                paths[i][j] = paths[i-1][j]+paths[i][j-1];
            }
        }

        return paths[m][n];
    }
}
