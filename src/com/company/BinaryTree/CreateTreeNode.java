package com.company.BinaryTree;

import com.company.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateTreeNode {

    public static TreeNode create(List<Integer> nums) {
        TreeNode output = null;
        // loop through and add each number
        for(Integer key : nums) {
            // if the root is empty then just set the num
            if (output == null) {
                output = new TreeNode(key);
            } else {
                // otherwise add each new node
                addNode(output, key);
            }
        }
        return output;
    }

    private static void addNode(TreeNode output, Integer key) {
        // use a queue to keep track of existing nodes so that
        // we can add a new node to the next available node
        // in order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(output);

        while (!queue.isEmpty()) {
            // return the next node and in the next line remove it
            output = queue.peek();
            queue.remove();

            // if the left is empty just add a new node there
            if (output.left == null) {
                output.left = new TreeNode(key);
                break;
            } else {
                // otherwise add the left node to the queue so
                // we can potentially loop through its children/leaves
                queue.add(output.left);
            }

            // repeat the same logic with the right node
            if (output.right == null) {
                output.right = new TreeNode(key);
                break;
            } else {
                queue.add(output.right);
            }
        }
    }


}
