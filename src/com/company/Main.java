package com.company;

import com.company.Arrays.MaxProfit;
import com.company.BinarySearchTree.BSTIterator;
import com.company.BinarySearchTree.BSTOperations;
import com.company.BinarySearchTree.TreeNode;
import com.company.BinarySearchTree.ValidateTree;
import com.company.LinkedLists.LinkedList;
import com.company.Queue.MovingAverage;
import com.company.Sorting.BubbleSort;
import com.company.Sorting.MergeSort;
import com.company.Sorting.QuickSort;
import com.company.Sorting.SelectionSort;

import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        showLinkedListExamples();
        showBinarySearchTreeExamples();
        showQueueExamples();
        showSortingExamples();
        showGraphExamples();
        showArrayExamples();
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

    private static void showArrayExamples() {
        MaxProfit maxProfit = new MaxProfit();
        int profit = maxProfit.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("Max Profit: " + profit);
    }

}