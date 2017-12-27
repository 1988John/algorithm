package easy.bsTree;

import domain.ListNode;
import domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/21.
 */
public class TwoSumForth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(7);

        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(12);
        TreeNode root6 = new TreeNode(18);

        root.left = root1;
        root.right = root4;

        root1.left = root2;
        root1.right = root3;


        root4.left = root5;
        root4.right = root6;

        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root,list);

        System.out.println(list.toString());

    }
    /**
     *@Author: jiangwang
     *@Description:
     *@Date: 22:15 2017/12/21
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root,list);
        Integer[] intArr = new Integer[list.size()];
        list.toArray(intArr);

        int value;

        for (int i=0;i<intArr.length;i++){
            value = k - intArr[i];
            int index = Arrays.binarySearch(intArr, value);
            if(index >= 0 && index != i){
                return true;
            }
        }
        return false;

    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    public static void inorderTraversal(TreeNode root, List<Integer> list ){
        if(root != null){
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }

}
