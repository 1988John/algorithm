package medium.dynamicProgramming;

import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2018/1/8.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int high = triangle.size();
        int[][] min = new int[high][triangle.get(high-1).size()];
        min[0][0] = triangle.get(0).get(0);

        for(int i=1;i<triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                if (j==0)
                    min[i][j] = min[i-1][0]+ triangle.get(i).get(j);
                else if (j==triangle.get(i).size()-1)
                    min[i][j] = min[i-1][j-1] + triangle.get(i).get(j);
                else
                    min[i][j] = Math.min(min[i-1][j-1],min[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int minSum = min[high-1][0];
        for(int i=0;i<min[high-1].length;i++){
            minSum = min[high-1][i] < minSum ? min[high-1][i] : minSum;
        }
        return minSum;
    }

}
