package com.akgarg.dsalgo.linkedlist;

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    int getData() {
        return data;
    }

    void setData(int data) {
        this.data = data;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}