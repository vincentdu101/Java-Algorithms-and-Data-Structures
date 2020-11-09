package com.company.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreadthFirstSearchRecursion {

    private static int DEPTH = -1;

    // takes an arraylist based graph structure
    public static int findDepth(List<List<Integer>> graph, int start, int target) {
        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> queue = new ArrayList<>();
        queue.add(start);
        queue.add(DEPTH);
        return doBreadthFirstSearch(visited, queue, graph);
    }

    private static int doBreadthFirstSearch(Map<Integer, Boolean> visited,
                                            List<Integer> queue,
                                            List<List<Integer>> graph) {
        int at = queue.remove(0);

        if (at == DEPTH) {
            queue.add(DEPTH);
            return 1;
        }

        // we already visited this value
        if (visited.containsKey(at)) {
            return 0;
        }

        // visit the node
        visited.put(at, true);

        // add all neighbors to queue
        List<Integer> neighbors = graph.get(at);

        if (neighbors != null) {
            for (Integer next : neighbors) {
                if (!visited.containsKey(next)) {
                    queue.add(next);
                }
            }
        }

        int depth = 0;
        while (true) {
            // stop when the queue is empty (there's only one depth
            // token remaining)
            if (queue.size() == 1 && queue.get(0) == DEPTH) {
                break;
            }

            // the depth is the sum of all depths are encountered
            depth += doBreadthFirstSearch(visited, queue, graph);
        }

        return depth;
    }


}
