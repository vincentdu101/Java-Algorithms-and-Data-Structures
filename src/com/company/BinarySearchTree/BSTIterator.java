package com.company.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

    // use Queue because a Queue is FIFO
    private Queue<TreeNode> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        pushIntoQueue(root);
    }

    /** @return the next smallest number */
    public int next() {
        // if no number return -1
        TreeNode node = new TreeNode(-1);

        // get the next number, FIFO
        if (queue.size() > 0) {
            node = queue.remove();
        }

        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return queue.size() > 0;
    }

    private void pushIntoQueue(TreeNode root) {
        if (root == null) {
            return;
        }

        // if there is a left side, we go into a recursion
        // on the left
        if (root.left != null) {
            pushIntoQueue(root.left);
        }

        // add the root node
        queue.add(root);

        // if there is a right side, we go into a recursion
        // on the right
        if (root.right != null) {
            pushIntoQueue(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
