package main.rbTree;

/**
 * Created by jiangwang on 12/16/17.
 */
public class RedBlackBST {
    private Node root;
    private  static  final boolean RED = true;
    private  static  final boolean BLACK = false;

    public void put(Integer key,String val){
        root = put(root,key,val);
        root.color = BLACK;
    }
    private Node put(Node h,Integer key,String val){
        if(h == null)
            return new Node(key,val,1,RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0)
            h.left = put(h.left,key,val);
        else if(cmp > 0)
            h.right = put(h.right,key,val);
        else
            h.val = val;
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);
        h.N = 1+ size(h.left) + size(h.right);
        return h;
    }




    private class Node{
        Integer key;
        String val;
        Node left,right;
        int N;
        boolean color;

        Node(Integer key, String val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+ size(h.left) + size(h.right);
        return  x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+ size(h.left) + size(h.right);
        return  x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private int size(Node x){
        if(x == null) return 0;
        else return x.N;
    }
}
