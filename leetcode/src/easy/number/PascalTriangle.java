package easy.number;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/28.
 */
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(3);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();

        if(numRows >= 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            listList.add(list);
        }
        for(int i=2;i<=numRows;i++){
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> lastList = listList.get(i-2);
            list.add(1);
            for(int j=1;j<lastList.size();j++){
                int num = lastList.get(j-1)+lastList.get(j);
                list.add(num);
            }
            list.add(1);
            listList.add(list);
        }
        return listList;
    }
}
