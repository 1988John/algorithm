package linkList;

import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class ReverseLinkedListSecond {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        ListNode head = reverseBetween(node1,3,4);
        ListNode h = re(node1,3,4);

        System.out.println(h);
    }

    public static ListNode re(ListNode head,int m,int n){
        if(m==n) return head;

        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0);//first's next points to mth
        ListNode second = new ListNode(0);//second's next points to (n+1)th

        int i=0;
        ListNode p = head;
        while(p!=null){
            i++;
            if(i==m-1){
                prev = p;
            }

            if(i==m){
                first.next = p;
            }

            if(i==n){
                second.next = p.next;
                p.next = null;
            }

            p= p.next;
        }
        if(first.next == null)
            return head;

        // reverse list [m, n]
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;

        while(p1!=null && p2!=null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if(prev!=null)
            prev.next = p1;
        else
            return p1;

        return head;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode beforeHead = new ListNode(head.val);
        ListNode beforeTail = null;
        int position = 1;
        while (position <=m){
            beforeHead = head.next;
            head = head.next;
            position ++;
        }

        ListNode current = head;
        ListNode previous = null;
//        int position = 1;
        while (current != null){
            ListNode next = current.next;
            if (position>m && position<n){
                current.next = previous;//交换
            }
            previous = current;
            current = next;
            position ++;
        }

        if (m==1){
            head = previous;
        }

        return head;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
