package com.company.LinkedLists;

public class LinkedListExamples {

    public static LinkedList buildLinkedList(int[] input) {
        LinkedList output = new LinkedList(0);

        for (int num : input) {
            LinkedList entry = new LinkedList(num);
            output.setNext(entry);
        }

        return output;
    }

    public static void traverseLinkedList(LinkedList input) {

        LinkedList output = input;

        while (output != null) {
            System.out.println(input.getVal());
            output = input.getNext();
        }

    }

}
