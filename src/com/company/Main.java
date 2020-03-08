package com.company;

import com.company.LinkedLists.LinkedList;

public class Main {

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();

        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtTail(4);
        linkedList.addAtIndex(3, 5);
        linkedList.deleteAtIndex(0);

        System.out.println("Index 1 value is: " + linkedList.get(1));

