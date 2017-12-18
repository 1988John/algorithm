package tree;

import java.util.TreeMap;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/8.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer,String> treeMap = new TreeMap<Integer, String>();
        treeMap.put(20,"twenty");
        treeMap.put(5,"five");
        treeMap.put(40,"forty");
        treeMap.put(1,"one");
        treeMap.put(10,"ten");
        treeMap.put(30,"thirty");
        treeMap.put(60,"sixty");
        treeMap.put(8,"eight");
        treeMap.put(15,"fif");
        treeMap.put(7,"seven");
        treeMap.put(6,"six");
        treeMap.put(9,"nine");

        System.out.println(treeMap.toString());

        treeMap.remove(5);
    }
}
