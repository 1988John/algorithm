package medium.dynamicProgramming;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/8.
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obs = {{0,0},{0,0}};

        int[][] obs1 = {{0,1}};


        int paths = uniquePathsWithObstacles(obs1);
        System.out.println(paths);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =  obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] paths = new int[m][n];

        for(int i=m-1;i>=0;i--){
            if (obstacleGrid[i][n-1] ==1){
                paths[i][n-1] = 0;
                break;
            } else paths[i][n-1] = 1;
        }

        for(int i=n-1;i>=0;i--){
            if (obstacleGrid[m-1][i] ==1){
                paths[m-1][i] = 0;
                break;
            } else paths[m-1][i] = 1;
        }

        for(int i=m-2;i>=0;i--){
            for (int j=n-2;j>=0;j--){
                if (obstacleGrid[i][j] ==1){
                    paths[i][j] = 0;
                } else if(obstacleGrid[i+1][j] == 1){
                    paths[i][j] = paths[i][j+1];
                } else if(obstacleGrid[i][j+1] == 1){
                    paths[i][j] = paths[i+1][j];
                }else {
                    paths[i][j] = paths[i+1][j]+paths[i][j+1];
                }
            }
        }

        return paths[0][0];
    }
}
