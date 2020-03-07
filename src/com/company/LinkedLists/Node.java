package com.company.LinkedLists;

public class Node {

    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

}
