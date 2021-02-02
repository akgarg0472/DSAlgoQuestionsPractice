package com.akgarg.dsalgo.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);
        Node fourth = new Node(50);

        root.setNext(first);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        System.out.print("Linked list before reverse: ");
        printLinkedList(root);
        System.out.print("Linked list after reverse: ");
        root = reverseLinkedList(root);
        printLinkedList(root);
    }

    static Node reverseLinkedList(Node root) {
        if (root == null) {
            return null;
        }

        if (root.getNext() != null) {
            Node firstPointer = root;   // used to hold the reference of next node (initially points to root node)
            Node secondPointer = root;  // used to hold the reference of current node (initially points to root node)
            Node tempPointer = null;    // used to hold the reference of previous node (initially null because no previous element)

            // traverse until list become empty
            while (firstPointer != null) {
                firstPointer = firstPointer.getNext();  // holds the reference of next node
                secondPointer.setNext(tempPointer);     // changes the next field to previous node
                tempPointer = secondPointer;            // now previous pointer points to current node
                secondPointer = firstPointer;           // pointer holding current node now points to next node
            }

            root = tempPointer;     // changing the root node reference to the last node of the linked list
        }
        return root;
    }

    private static void printLinkedList(Node root) {
        if (root == null) {
            System.out.println("Empty Linked List");
            return;
        }

        Node pointer = root;

        while (pointer != null) {
            System.out.print(pointer.getData() + " ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }
}

