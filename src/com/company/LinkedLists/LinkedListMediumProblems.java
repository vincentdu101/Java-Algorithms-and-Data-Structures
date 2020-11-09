package com.company.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMediumProblems {

    public LinkedListMediumProblems() {}

    /*
    Reverse a linked list from position m to n. Do it in one-pass.

            Note: 1 ≤ m ≤ n ≤ length of list.

            Example:

    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // vals keep track of all of the values
        // we will use this as a cache of the original
        // positions of the values
        List<Integer> vals = new ArrayList<>();

        // create a reference to the start of the linked list
        // node at the end, even though copy is changing
        // and iterating to the next reference, the head object
        // remains pointing to the start of the head
        ListNode copy = head;
        while (copy != null) {
            vals.add(copy.val);
            copy = copy.next;
        }

        int end = n - 1;
        int begin = m - 1;
        // start a new node, goal is to copy over the
        // values into the new node, but again use head
        // as the object that will iterate, prev remains
        // at the start
        ListNode prev = new ListNode();
        head = prev;
        for (int i = 0; i < vals.size(); i++) {
            // if we reached the start of where we want
            // to reverse the elements, and do the swap action
            if (begin == i && begin < end) {
                int temp = vals.get(begin);
                vals.set(begin, vals.get(end));
                vals.set(end, temp);

                // after the swap, we narrow the range to swap the next
                // elements in between
                begin++;
                end--;
            }

            // override the head with the new values
            // then iterate over to move to the next
            // pointer
            head.next = new ListNode(vals.get(i));
            head = head.next;
        }

        // return prev.next because the start is empty and the
        // next node is where the values begin
        return prev.next;
    }

}
