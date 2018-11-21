package linkList;

import java.util.ArrayList;
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

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);

        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);

//        node1.next = node2;

        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode = addTwoNumbers(node1, node2);
        System.out.println(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = reverseList(l1);
        int number1 = turnLinkedListToNumber(listNode1);
        ListNode listNode2 = reverseList(l2);
        int number2 = turnLinkedListToNumber(listNode2);
        int number = number1 + number2;
        return turnNumberToReverseLinkedList(number);
    }

    public static ListNode turnNumberToReverseLinkedList(int number) {
        int value = number % 10;
        ListNode node = new ListNode(value);
        ListNode current = node;
        number /= 10;
        while (number > 0) {
            int temp = number % 10;
            ListNode next = new ListNode(temp);
            current.next = next;
            current = next;
            number /= 10;
        }
        return node;
    }


    public static int turnLinkedListToNumber(ListNode head){
        int number = 0;
        List<Integer> numberList = new ArrayList<>();
        while (head != null){
            numberList.add(head.val); 
            head = head.next;
        }
        int size = numberList.size();
        for (int i = 0; i < size; i++) {
            number += numberList.get(i)*Math.pow(10,size-1-i);
        }
        return number;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode next ;
        ListNode previous = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    static class ListNode {

        public static void main(String[] args) {
            System.out.println(1%10);
        }
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
