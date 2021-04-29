package com.company.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    /**
     * Given a reference of a node in a connected undirected graph.
     *
     * Return a deep copy (clone) of the graph.
     *
     * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
     *
     * class Node {
     *     public int val;
     *     public List<Node> neighbors;
     * }
     *
     * Test case format:
     *
     * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node
     * with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
     *
     * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
     * neighbors of a node in the graph.
     *
     * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference
     * to the cloned graph.
     *
     * Example 1:
     *
     * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
     * Output: [[2,4],[1,3],[2,4],[1,3]]
     * Explanation: There are 4 nodes in the graph.
     * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
     * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     *
     * Example 2:
     *
     *
     * Input: adjList = [[]]
     * Output: [[]]
     * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it
     * does not have any neighbors.
     *
     * Example 3:
     *
     * Input: adjList = []
     * Output: []
     * Explanation: This an empty graph, it does not have any nodes.
     *
     * Example 4:
     *
     * Input: adjList = [[2],[1]]
     * Output: [[2],[1]]
     *
     * Constraints:
     *
     * 1 <= Node.val <= 100
     * Node.val is unique for each node.
     * Number of Nodes will not exceed 100.
     * There is no repeated edges and no self-loops in the graph.
     * The Graph is connected and all nodes can be visited starting from the given node.
     */

    private static Map<GraphNode, GraphNode> visited = new HashMap<>();
    public static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }

        // if the node was already visited before
        // return the clone from the visited dictionary
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create a clone for the given node
        // note that we don't have cloned neighbors as of now
        // hence []
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList());

        // the key is original node and value being the cloned node
        visited.put(node, cloneNode);

        // iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to their
        // cloned node
        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
