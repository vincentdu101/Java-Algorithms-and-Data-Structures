package com.company.BinarySearchTree;

import com.company.util.TreeNode;

public class ValidateTree {


    public static boolean isValidBST(TreeNode tree) {

        if (tree == null) {
            return true;
        }

        // if we find the left side is larger than the root
        // it is not a binary search tree
        if (tree.left != null && tree.val <= tree.left.val) {
            return false;
        }

        // if we find the right is smaller than the root
        // it is not a binary search tree
        if (tree.right != null && tree.val >= tree.right.val) {
            return false;
        }

        // verify both the left and right sides of the tree
        return isValidBST(tree.left) && isValidBST(tree.right);

    }

}
