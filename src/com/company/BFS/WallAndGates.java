package com.company.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallAndGates {

    /*
        You are given an m x n grid rooms initialized with these three possible values.

        -1 A wall or an obstacle.
        0 A gate.
        INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
        the distance to a gate is less than 2147483647.
        Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
        filled with INF.

        Example 1:

        Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],
        [0,-1,2147483647,2147483647]]
        Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

        Example 2:

        Input: rooms = [[-1]]
        Output: [[-1]]

        Example 3:

        Input: rooms = [[2147483647]]
        Output: [[2147483647]]

        Example 4:

        Input: rooms = [[0]]
        Output: [[0]]


        Constraints:

        m == rooms.length
        n == rooms[i].length
        1 <= m, n <= 250
        rooms[i][j] is -1, 0, or 231 - 1.
     */

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );

    public static void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;

        if (rows == 0) {
            return;
        }

        int cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // queue up all of the gates
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[] {row, col});
                }
            }
        }

        // using the gate as the starting point, go through
        // each square and increment from there until
        // we reach the end of the board
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            // for each square add the adjacent squares around it
            // to the queue
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= rows || c >= cols || rooms[r][c] != EMPTY) {
                    continue;
                }

                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r, c});
            }
        }
    }

}
