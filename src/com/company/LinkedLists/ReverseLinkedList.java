package com.company.LinkedLists;

/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public ReverseLinkedList() {}

    public ListNode reverseList(ListNode head) {
        // rule out base cases
        if (head == null || head.next == null) {
            return head;
        }

        // create a new node with the first head value
        ListNode newHead = new ListNode(head.val);

        // call reverse but with the next node in head
        return reverse(newHead, head.next);
    }

    private ListNode reverse(ListNode output, ListNode head) {
        // if we run out of nodes, exit
        if (head == null) {
            return output;
        }

        // here we basically move the output as the next
        // node for head's val through creating a node for it
        // temp -> output
        ListNode temp = new ListNode(head.val);
        temp.next = output;
        output = temp;

        // recurse again but this time with the next node in head
        return reverse(output, head.next);
    }

}
