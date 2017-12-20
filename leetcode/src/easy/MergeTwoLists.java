package easy;

import domain.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/19.
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode r1 = new ListNode(3);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(7);
        ListNode r4 = new ListNode(8);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;

        ListNode listNode = mergeTwoLists1(l1, r1);
        System.out.println(listNode.toString());


    }
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    /**
     *@Author: jiangwang
     *@Description:
     *@Date: 17:38 2017/12/19
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode nextNode = result;
        int temp;
        while(l1 != null && l2 != null){

            if(l1.val<=l2.val){
                temp = l1.val;
                l1 = l1.next;
            }else{
                temp = l2.val;
                l2 = l2.next;
            }
            nextNode.next = new ListNode(temp);
            nextNode = nextNode.next;
        }

        while (l1 != null){//l1剩余的
            nextNode.next = new ListNode(l1.val);
            nextNode = nextNode.next;
            l1 = l1.next;
        }

        while (l2 != null){//l2剩余的
            nextNode.next = new ListNode(l2.val);
            nextNode = nextNode.next;
            l2 = l2.next;
        }

        return result.next;
    }


}
