package com.company.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class LinkedListEasyProblems {

    public LinkedListEasyProblems() {}

    /*
        Given a singly linked list, determine if it is a palindrome.

        Example 1:

        Input: 1->2
        Output: false
        Example 2:

        Input: 1->2->2->1
        Output: true
     */
    public boolean isPalindrome(ListNode head) {
        // we'll use an array list to track the values
        List<Integer> vals = new ArrayList<>();

        // loop through the list node to add the values
        // to the array list
        while (head != null) {
            vals.add(Integer.valueOf(head.val));
            head = head.next;
        }

        // get the last index
        int last = vals.size() - 1;

        // now loop over the arraylist and compare from
        // beginning index of 0 and the last index to see
        // if they aren't the same, in a palindrome the values
        // on each side of the list are reversed and the same
        for (int i = 0; i < vals.size(); i++) {
            if (last == 0) {
                break;
            }

            // if we find a mismatch return false
            if (vals.get(i).intValue() != vals.get(last).intValue()) {
                return false;
            }

            last--;
        }

        // otherwise the characters fit a palindrome definition
        return true;
    }

}
