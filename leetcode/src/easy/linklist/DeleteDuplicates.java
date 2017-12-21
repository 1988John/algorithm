package easy.linklist;

import domain.ListNode;

/**
 * Description:
 * Created by jiangwang3 on 2017/12/20.
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode listNode = deleteDuplicates(l1);
        System.out.println(listNode);
    }
    /**
     *@Author: jiangwang
     *@Description: Given a sorted linked list, delete all duplicates such that each element appear only once.
     *@Date: 11:09 2017/12/20
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node!= null){
            if(node.next != null && node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node =  node.next ;
            }
        }
        return head;
    }
}
