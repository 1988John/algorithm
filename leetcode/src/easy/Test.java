package easy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangwang on 12/18/17.
 */
public class Test {
    public static void main(String[] args) {
        String[] strArr = {"a","b","c"};
        List<String> stringList = Arrays.asList(strArr);
        boolean c = stringList.contains("c");

        Integer[] intArr = {1,2,3};
        List<Integer> integerList = Arrays.asList(intArr);
        boolean b = integerList.contains(3);

        int[] ints = {1,2,3,7,4,9,0};
        List<int[]> ints1 = Arrays.asList(ints);
        boolean contains = ints1.contains(3);


    }
}
