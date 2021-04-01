package com.company.BinaryTree;

import com.company.Backtracking.PalindromePartitioning;
import com.company.util.TreeNode;

public class FindTreeNode {

    public static TreeNode find(TreeNode root, int key) {
        // if the treenode is empty then return null
        if (root == null) {
            return null;
        }

        // if the root is matching the key, then return the root
        if (root.val == key) {
            return root;
        }

        // if the left node is matching then return the left
        if (root.left != null && root.left.val == key) {
            return root.left;
        }

        // if the right node is matching then return the right
        if (root.right != null && root.right.val == key) {
            return root.right;
        }

        // recurse and try to see if either the left or right side
        // has a match
        TreeNode left = find(root.left, key);
        TreeNode right = find(root.right, key);

        // if the left side found a match return the left response
        if (left != null) {
            return left;
        }

        // if the right side found a match return right response
        if (right != null) {
            return right;
        }

        return null;
    }

}
