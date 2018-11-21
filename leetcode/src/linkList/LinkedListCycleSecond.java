package linkList;

import java.util.HashSet;
import java.util.Set;

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

public class LinkedListCycleSecond {

    public ListNode hasCycle(ListNode head) {
        if (head == null){
            return null;
        }
        Set<ListNode> nodesSet = new HashSet<>();

        while (head.next != null){
            if (nodesSet.contains(head)){
                return head;
            }else {
                nodesSet.add(head);
            }
            head = head.next;
        }
        return null;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
