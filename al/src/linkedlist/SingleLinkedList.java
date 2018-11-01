package linkedlist;

/**
 * @author jiangwang3
 * @date 2018/11/1.
 */
public class SingleLinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

//        @Override
//        public String toString() {
//            return "Node{" + "value=" + value + ", next=" + next + '}';
//        }
    }

    public static void main(String[] args) {
        //创建链表的节点，创建了三个对象，那就是三个节点
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        //将这些节点，串连起来形成链表
        node0.next = node1;
        node1.next = node2;
//        Node head = reverse(node0);
        Node head = reverseLinkedList(node0);
        System.out.println(head);
    }

    static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    public static Node reverse(Node node) {
        Node currentNode = node;
        Node previousNode = null;
        Node head = null;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                head = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return head;
    }

}
