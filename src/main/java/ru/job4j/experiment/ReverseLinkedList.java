package ru.job4j.experiment;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node6 = new Node(6, null);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node before = node1;
        while (before != null) {
            System.out.println(before.val);
            before = before.next;
        }

        Node after = reverse(node1);
        while (after != null) {
            System.out.println(after.val);
            after = after.next;
        }

    }

    public static Node reverse(Node oldHead) {
        if (oldHead.next == null) {
            return oldHead;
        }
        Node previousNode = null;
        Node newHead = oldHead;
        Node nextNode = newHead.next;
        while (nextNode != null) {
            newHead.next = previousNode;
            previousNode = newHead;
            newHead = nextNode;
            nextNode = nextNode.next;
        }
        newHead.next = previousNode;
        return newHead;
    }

    public static class Node {
        public int val;
        public Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}