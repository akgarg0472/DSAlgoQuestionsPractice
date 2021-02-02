package com.akgarg.dsalgo.linkedlist;

public class MergeSortedLinkedLists {

    public static void main(String[] args) {

//        Sample Case 1
        Node nodeOne = new Node(12);
        nodeOne.setNext(new Node(22));
        nodeOne.getNext().setNext(new Node(25));
        nodeOne.getNext().getNext().setNext(new Node(26));
        nodeOne.getNext().getNext().getNext().setNext(new Node(30));

        Node nodeTwo = new Node(4);
        nodeTwo.setNext(new Node(15));
        nodeTwo.getNext().setNext(new Node(32));
        nodeTwo.getNext().getNext().setNext(new Node(48));

        System.out.print("First Linked list: ");
        print(nodeOne);
        System.out.print("Second Linked list: ");
        print(nodeTwo);
        System.out.print("Merged Linked list: ");
        Node result = merge(nodeOne, nodeTwo);
        print(result);
        System.out.println();


//        Sample Case 2
        Node one = new Node(1);
        one.setNext(new Node(3));
        one.getNext().setNext(new Node(7));

        Node two = new Node(2);
        two.setNext(new Node(4));
        two.getNext().setNext(new Node(6));
        two.getNext().getNext().setNext(new Node(10));

        System.out.print("First Linked list: ");
        print(one);
        System.out.print("Second Linked list: ");
        print(two);
        System.out.print("Merged Linked list: ");
        Node sorted = merge(one, two);
        print(sorted);
    }

    static Node merge(Node listOne, Node listTwo) {
        if (listOne == null && listTwo == null) {
            return null;
        }

        Node first = listOne;
        Node second = listTwo;

        Node start = null;
        Node pointer = null;

        while (first != null && second != null) {
            if (start == null && pointer == null) {
                if (first.getData() < second.getData()) {
                    start = first;
                    first = first.getNext();
                } else {
                    start = second;
                    second = second.getNext();
                }
                pointer = start;
            } else {
                if (first.getData() < second.getData()) {
                    pointer.setNext(first);
                    first = first.getNext();
                } else {
                    pointer.setNext(second);
                    second = second.getNext();
                }
                pointer = pointer.getNext();
            }
        }

        while (first != null) {
            pointer.setNext(first);
            pointer = pointer.getNext();
            first = first.getNext();
        }

        while (second != null) {
            pointer.setNext(second);
            pointer = pointer.getNext();
            second = second.getNext();
        }

        return start;
    }

    private static void print(Node node) {
        if (node == null) {
            System.out.println("null");
        }

        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}

