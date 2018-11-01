package linkedlist.reverse;

import linkedlist.Node;

/**
 * @author jiangwang3
 * @date 2018/11/1.
 */
public class ReverseList {
    public static void main(String[] args) {
        //创建链表的节点，创建了三个对象，那就是三个节点
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        //将这些节点，串连起来形成链表
        node0.setNext(node1);
        node1.setNext(node2);

        Node head = node0;

        Node node = reverseLinkedList(node0);

//        node0.getNext().setNext(node0);
//        node0.setNext(node0.getNext().getNext());
    }

    static Node reverseLinkedList(Node node) {
        Node previousNode = null;
        Node currentNode = node;
        Node headNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.setNext(previousNode);

            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }
}
