package com.company.BinaryTree;

import com.company.util.TreeNode;

import java.util.*;

public class LowestCommonAncestorStack {

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        // stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // hashmap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            // while traversing the tree, keep saving the parent
            // pointers
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // ancestors set() for node p
        Set<TreeNode> ancestors = new HashSet<>();

        // process all ancestors for node p using parent pointers
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // the first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

}
