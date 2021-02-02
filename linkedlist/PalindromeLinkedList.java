package com.akgarg.dsalgo.linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        Node root = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node five = new Node(30);
        Node six = new Node(20);
        Node seven = new Node(10);
        root.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(five);
        five.setNext(six);
        six.setNext(seven);

        System.out.println("Is Linked list palindrome(Stack): " + isPalindromeStack(root));
        System.out.println("Is Linked list palindrome(Reverse): " + isPalindromeReverse(root));
    }


    // reversing half part of linked list and comparing reversed linked list with original linked list to determine if linked list is palindrome or not
    private static boolean isPalindromeReverse(Node root) {
        Node fastPointer = root;
        Node slowPointer = root;
        Node mid = null;

        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }

        if (fastPointer != null) {
            mid = slowPointer.getNext();
        } else {
            mid = slowPointer;
        }

        Node previous = null;
        Node next;

        while (mid != null) {
            next = mid.getNext();
            mid.setNext(previous);
            previous = mid;
            mid = next;
        }

        // now previous point to previously last node which is acting as first node of reversed part
        while (previous != null) {
            if (previous.getData() != root.getData()) {
                return false;
            }

            previous = previous.getNext();
            root = root.getNext();
        }

        return true;
    }


    // using stack and determining if linked list is palindrome or not
    private static boolean isPalindromeStack(Node root) {
        boolean isPalindrome = false;

        Stack<Integer> stack = new Stack<>();
        Node temp = root;

        while (temp != null) {
            stack.push(temp.getData());
            temp = temp.getNext();
        }

        while (!stack.isEmpty()) {
            isPalindrome = stack.pop() == root.getData();
            root = root.getNext();
        }

        return isPalindrome;

    }

}
