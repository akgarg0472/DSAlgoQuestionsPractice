package com.akgarg.dsalgo.linkedlist;

import java.util.Stack;

public class DetectLoopInLinkedList {

    public static void main(String[] args) {

        Node firstList = new CreateLinkedList().getLinkedList();

        Node secondList = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node five = new Node(50);
        Node six = new Node(60);
        secondList.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(five);
        five.setNext(six);
        six.setNext(second);

        // first linked list: 10->20->30->40->50
        /* second linked list: 10->20->30->40->50->60
                                    ↑               ↓
                                    |_______________|
        */

        System.out.println("is any loop(Stack) in first: " + isLoopStack(firstList));
        System.out.println("is any loop(Stack) in second: " + isLoopStack(secondList));
        System.out.println("is any loop(Pointer) in first: " + isLoopPointers(firstList));
        System.out.println("is any loop(Pointer) in first: " + isLoopPointers(secondList));
    }


    // using stack to keep track of visited nodes reference and if visited nodes appears again means there is a loop in linked list
    private static boolean isLoopStack(Node root) {
        if (root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();

        while (root != null) {
            if (!stack.contains(root)) {
                stack.push(root);
            } else {
                return true;
            }
            root = root.getNext();
        }

        return false;
    }


    // Floyd cycle finding Algorithm (also called as tortoise-hair algorithm)
    private static boolean isLoopPointers(Node root) {
        if (root == null) {
            return false;
        }

        Node slowPointer = root;    // reference which will moves by one node only
        Node fastPointer = root.getNext();  // reference which will move by two nodes

        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
}
