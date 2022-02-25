package easy;

/**
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */

class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val, Node next) {
        this.next = next;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node:" + this.val;
    }
}

public class MiddleNode {

    // 方式一 先遍历一遍单链表 获取链表长度 之后再遍历长度的一半
//    public static Node middleNode(Node head) {
//        int nodeCount = 1;
//        Node nextNode = head.next;
//        Node middleNode = head.next;
//        while (nextNode != null) {
//            nextNode = nextNode.next;
//            nodeCount++;
//        }
//        if (nodeCount == 1) {
//            return head;
//        } else {
//            for (int i = 1; i < (nodeCount / 2); i++) {
//                middleNode = middleNode.next;
//            }
//            return middleNode;
//        }
//    }

    // 方式二 利用快慢指针  快指针一次走两步  慢指针一次走一步  快指针走完的时候慢指针刚好走到一半
    public static Node middleNode(Node head) {
        Node quickPoint, slowPoint;
        if (head.next == null) {
            return head;
        } else {
            quickPoint = head.next.next;
            slowPoint = head.next;
            if (quickPoint != null) {
                while (quickPoint != null && quickPoint.next != null) {
                    quickPoint = quickPoint.next.next;
                    slowPoint = slowPoint.next;
                }
            }
            return slowPoint;
        }
    }

    public static void main(String[] args) {
        Node node6 = new Node(6, null);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        System.out.println(middleNode(node1));
    }


}
