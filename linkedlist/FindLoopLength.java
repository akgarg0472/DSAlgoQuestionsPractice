package com.akgarg.dsalgo.linkedlist;

public class FindLoopLength {
    public static void main(String[] args) {

        Node root = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node five = new Node(50);
        Node six = new Node(60);
        Node seven = new Node(70);
        root.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(second);

        /* second linked list: 10->20->30->40->50->60->70
                                    ↑                   ↓
                                    |___________________|
        */
        System.out.println("Size of loop in linked list is: " + getLoopSize(root));
    }


    // Assuming that there is surely loop in the linked list
    private static int getLoopSize(Node root) {
        int size = 0;

        Node slowPointer = root;
        Node fastPointer = root.getNext();

        while (slowPointer != null && fastPointer != null) {
            if (slowPointer == fastPointer) {
                break;
            }
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
            size++;
        }

        return size;
    }
}
