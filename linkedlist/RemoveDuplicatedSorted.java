package com.akgarg.dsalgo.linkedlist;

public class RemoveDuplicatedSorted {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node second = new Node(10);
        Node third = new Node(20);
        Node fourth = new Node(20);
        Node five = new Node(30);
        Node six = new Node(30);
        Node seven = new Node(40);
        Node eight = new Node(40);
        root.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(eight);

        print(root);
        removeDuplicates(root);
        print(root);
    }

    private static void removeDuplicates(Node root) {
        Node node = root;

        while (node != null && node.getNext() != null) {
            if (node.getNext().getData() == node.getData()) {
                node.setNext(node.getNext().getNext());
            } else {
                node = node.getNext();
            }
        }
    }

    private static void print(Node root) {
        while (root != null) {
            System.out.print(root.getData() + " ");
            root = root.getNext();
        }
        System.out.println();
    }
}
