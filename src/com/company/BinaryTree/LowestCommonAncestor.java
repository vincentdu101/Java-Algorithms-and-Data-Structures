package com.company.BinaryTree;

import com.company.util.TreeNode;

public class LowestCommonAncestor {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
     * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
     * node to be a descendant of itself).”

     * Example 1:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     *
     * Example 2:
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     *
     * Example 3:
     * Input: root = [1,2], p = 1, q = 2
     * Output: 1

     * Constraints:
     *
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the tree.
     */

    private TreeNode ans;

    public LowestCommonAncestor() {
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // if we reached the end of a branch, return false
        if (currentNode == null) {
            return false;
        }

        // left recursion, if left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // right recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // if the currentNode is either p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // if any two of the flags left, right, or mid become true
        if (left + right + mid >= 2) {
            this.ans = currentNode;
        }

        // return true if any one of the three bool values is true
        return (mid + left + right > 0);
    }

    public TreeNode recurseFind(TreeNode root, TreeNode p, TreeNode q) {
        // traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }
}
