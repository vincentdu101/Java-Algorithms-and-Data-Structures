package com.company;

import com.company.Arrays.MaxProfit;
import com.company.Backtracking.GenerateParenthesis;
import com.company.Backtracking.PalindromePartitioning;
import com.company.Backtracking.WordSearch;
import com.company.BinarySearchTree.BSTIterator;
import com.company.BinarySearchTree.BSTOperations;
import com.company.BinarySearchTree.TreeNode;
import com.company.BinarySearchTree.ValidateTree;
import com.company.LinkedLists.*;
import com.company.Queue.MovingAverage;
import com.company.Sorting.BubbleSort;
import com.company.Sorting.MergeSort;
import com.company.Sorting.QuickSort;
import com.company.Sorting.SelectionSort;
import com.company.Stack.Problems;

import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        showLinkedListExamples();
        showBinarySearchTreeExamples();
        showQueueExamples();
        showSortingExamples();
        showGraphExamples();
        showArrayExamples();
        showBacktrackExamples();
        showStackExamples();
    }

    private static void showLinkedListExamples() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtTail(4);
        linkedList.addAtIndex(3, 5);
        linkedList.deleteAtIndex(0);
        System.out.println("Index 1 value is: " + linkedList.get(1));
        linkedList.traverseList();

        LinkedListEasyProblems easyProblems = new LinkedListEasyProblems();
        int[] palindrome = new int[] {1, 2, 2, 1};
        ListNode palindromeList = createListNode(palindrome);
        boolean isPalindrome = easyProblems.isPalindrome(palindromeList);
        System.out.println("Is Palindrome: " + isPalindrome);

        LinkedListMediumProblems mediumProblems = new LinkedListMediumProblems();
        int[] input = new int[] {1, 2, 3, 4, 5};
        ListNode inputList = createListNode(input);
        ListNode output = mediumProblems.reverseBetween(inputList, 2, 4);
        System.out.println("reverse linked list in between values");
        printListNode(output);

        ListNode reverseInput = createListNode(input);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode outputReverse = reverseLinkedList.reverseList(reverseInput);
        System.out.println("reverse linked list");
        printListNode(outputReverse);
    }

    private static ListNode createListNode(int[] input) {
        ListNode output = new ListNode();
        ListNode ref = output;

        for (int i = 0; i < input.length; i++) {
            output.next = new ListNode(input[i]);
            output = output.next;
        }
        return ref.next;
    }

    private static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static void showBinarySearchTreeExamples() {

        // valid tree
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);
        System.out.println("Is tree a valid binary search tree: " + ValidateTree.isValidBST(tree));

        // invalid tree
        TreeNode invalidTree = new TreeNode(2);
        invalidTree.left = new TreeNode(4);
        invalidTree.right = new TreeNode(3);
        System.out.println("Is tree a valid binary search tree: " + ValidateTree.isValidBST(invalidTree));

        // iterator
        BSTIterator iterator = new BSTIterator(tree);
        System.out.println("Next Node Value is: " + iterator.next());
        System.out.println("Iterator still has next node: " + iterator.hasNext());

        // search for node val
        System.out.println("Node search for 3: " + BSTOperations.searchBST(tree, 3).val);

        // insert into BST
        BSTOperations.insertIntoBST(tree, 5);
        System.out.println("Node search after insert for 5: " + BSTOperations.searchBST(tree, 5).val);
    }

    private static void showQueueExamples() {
        // moving average
        MovingAverage m = new MovingAverage(3);
        System.out.println("The average should be 1.00000: " + m.next(1));
        System.out.println("The average should be 5.50000: " + m.next(10));
        System.out.println("The average should be 4.66667: " + m.next(3));
        System.out.println("The average should be 6.00000: " + m.next(5));
    }

    private static void showSortingExamples() {
        int[] input = new int[]{4, 2, 1, 567, 3, 8, 1};

        System.out.println("Selection Sort");
        SelectionSort selectionSort = new SelectionSort(input.clone());
        selectionSort.sortArray();
        selectionSort.printArray();

        System.out.println("Bubble Sort");
        BubbleSort bubbleSort = new BubbleSort(input.clone());
        bubbleSort.sortArray();
        bubbleSort.printArray();

        System.out.println("Merge Sort");
        MergeSort mergeSort = new MergeSort(input.clone());
        mergeSort.sortArray();
        mergeSort.printArray();

        System.out.println("Quick Sort");
        QuickSort quickSort = new QuickSort(input.clone());
        quickSort.sortArray();
        quickSort.printArray();

    }

    private static void showGraphExamples() {

    }

    private static void showStackExamples() {
        String input = "/a/./b/../../c/";
        String output = Problems.simplifyPath(input);
        System.out.println(input + " is " + output);
    }

    private static void showArrayExamples() {
        MaxProfit maxProfit = new MaxProfit();
        int profit = maxProfit.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("Max Profit: " + profit);
    }

    private static void showBacktrackExamples() {
        List<String> output = GenerateParenthesis.generate(3);
        output.forEach(out -> {
            System.out.println(out);
        });

        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        WordSearch wordSearch = new WordSearch(board);
        String word = "ABCCED";
        System.out.println(word + " Exists: " + wordSearch.exist(word));

        PalindromePartitioning.partition("aab");
    }

}