package com.company;

import com.company.BinarySearchTree.BSTIterator;
import com.company.BinarySearchTree.SearchTree;
import com.company.BinarySearchTree.TreeNode;
import com.company.BinarySearchTree.ValidateTree;
import com.company.LinkedLists.LinkedList;

public class Main {

    public static void main(String[] args) {

        showLinkedListExamples();
        showBinarySearchTreeExamples();

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
        System.out.println("Node search for 3: " + SearchTree.searchBST(tree, 3).val);
    }

}