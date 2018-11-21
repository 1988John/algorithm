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

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSet = new HashSet<>();
        while (head.next != null){
            if (nodesSet.contains(head)){
                return true;
            }else {
                nodesSet.add(head);
            }
            head = head.next;
        }
        return false;
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
