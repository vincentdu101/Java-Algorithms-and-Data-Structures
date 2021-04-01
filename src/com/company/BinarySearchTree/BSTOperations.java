package com.company.BinarySearchTree;

import com.company.util.TreeNode;

public class BSTOperations {

    public static TreeNode searchBST(TreeNode root, int val) {
        // if the root is empty just return null
        if (root == null) {
            return null;
        }

        // if the root is a match return the root
        if (root.val == val) {
            return root;
        }

        // We now try to see if the value we're looking for is
        // lower or higher than the root's value.

        // if the value we're looking for is smaller than the root
        // we go left, if it's bigger we go right

        // recursively go into each side based on that condition
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }

        // if we still can't find a match at this point just return
        // null
        return null;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        // if the root is empty, make a new TreeNode and return it
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        // see if the value we want to add is smaller or
        // bigger than the root

        // if smaller add to the left side, if larger add
        // it to the right

        // recursively go into each side until we reach the end
        // before adding
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        // return the root node with the new addition
        return root;
    }

}
