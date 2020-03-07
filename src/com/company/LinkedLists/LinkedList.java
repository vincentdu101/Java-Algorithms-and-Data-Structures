package com.company.LinkedLists;

public class LinkedList {

    private Node node;


    /** Initialize your data structure here. */
    public LinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        // check to see if it's the first node we want
        // if it exists return it
        if (index == 0 && node != null) {
            return node.getVal();
        }

        int count = 0;

        // use a copy of the original node so we don't
        // overwrite it
        Node output = node;

        // while we are counting to index and we have nodes
        while (count <= index && output != null) {

            // check to see if we have a match and return it
            // if we do
            if (count == index) {
                return output.getVal();
            }

            // otherwise we keep going
            output = output.getNext();
            count++;
        }

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        // if we have an empty node just create a new node
        if (node == null) {
            node = new Node(val);
        } else {
            // save a copy of the original node
            Node temp = node;

            // initialize a new root node
            node = new Node(val);

            // save the copy of the original to the next reference in the new
            // root node
            node.setNext(temp);
        }

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        if (node == null) {
            node = new Node(val);
        } else {

//            Node output =

        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is greater
     * than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }

    /** traverse linkedList **/
    public void traverseList() {

        Node output = node;

        while (output != null) {
            System.out.println("Node value: " + output.getVal());
            output = output.getNext();
        }

    }

}
