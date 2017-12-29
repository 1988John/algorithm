package easy.bsTree;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/27.
 */
public class TrimBST {
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

        TreeNode treeNode = trimBST(root, 6, 16);
        System.out.println(treeNode);


    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public void treeDelete(TreeNode parent ,TreeNode node){
        if(node.left == null){
            node = node.right;
        }else if (node.right == null){
            node = node.left;
        }else {
            TreeNode replaceParent = treeMin(node.right);
            if(node.val != replaceParent.val){
                node.val = replaceParent.left.val;
                replaceParent.left = null;
            }else {
                node.right.left = node.left;
                if(parent.left.val == node.val)
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }
        }

    }
    /**
     *@Author: jiangwang
     *@Description: 找出min的父节点
     *@Date: 10:51 2017/12/29
     */
    public TreeNode treeMin(TreeNode tree){
        TreeNode parent = tree;
        while (tree.left != null){
            parent = tree;
            tree = parent.left;
        }

        return parent;
    }

}
