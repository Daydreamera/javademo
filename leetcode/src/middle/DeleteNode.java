package middle;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

class Node{
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

class LinkNode {
    Node head;
    Node tail;
    int length;

    public LinkNode() {
    }

    public LinkNode(Node head) {
        this.head = head;
        this.tail = head;
        this.length = 1;
    }

    public void addNode(Node node) {
        this.tail.next = node;
        this.tail = node;
        this.length++;
    }

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public LinkNode removeNthFromEnd(LinkNode linkNode, int n) {
        Node quick = linkNode.head, slow = linkNode.head;
        if (linkNode.head.next == null) {
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                quick = quick.next;
            }
            if (quick == null) {
                linkNode.head = linkNode.head.next;
                linkNode.length--;
                return linkNode;
            } else {
                while (quick.next != null) {
                    quick = quick.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
                linkNode.length--;
                return linkNode;
            }
        }

    }

    @Override
    public String toString() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return StringUtils.join(arrayList, "->");
    }
}

public class DeleteNode {

    public static void main(String[] args) {
        LinkNode ln = new LinkNode(new Node(1, null));
        ln.addNode(new Node(2, null));
        ln.addNode(new Node(3, null));
        ln.addNode(new Node(4, null));
        ln.addNode(new Node(5, null));
        ln.removeNthFromEnd(ln, 5);
        System.out.println(ln);
        System.out.println(ln.length);
    }
}
