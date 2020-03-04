package com.company.LinkedLists;

public class LinkedList {

    private int val = 0;
    private LinkedList next;

    public LinkedList(int val) {
        this.val = val;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList getNext() {
        return next;
    }

    public int getVal() {
        return val;
    }

}
