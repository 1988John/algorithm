package main.rbTree;

/**
 * Created by jiangwang on 12/16/17.
 */
public class App {
    public static void main(String[] args) {
        RedBlackBST rbTree = new RedBlackBST();
        rbTree.put(10,"a");
        rbTree.put(8,"b");
        rbTree.put(6,"c");

        System.out.println(rbTree);
    }
}
