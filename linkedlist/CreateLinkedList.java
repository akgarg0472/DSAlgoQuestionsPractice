package com.akgarg.dsalgo.linkedlist;

@SuppressWarnings("all")
class CreateLinkedList {

    Node getLinkedList() {
        Node root = new Node(10);
        Node first = new Node(20);
        Node second = new Node(30);
        Node third = new Node(40);
        Node fourth = new Node(50);

        root.setNext(first);
        first.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        return root;
    }
}
