package com.company;

import com.company.LinkedLists.LinkedListExamples;
import com.company.LinkedLists.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList entries = LinkedListExamples.buildLinkedList(new int[]{0, 1, 2, 3, 4});

        LinkedListExamples.traverseLinkedList(entries);

    }
}
