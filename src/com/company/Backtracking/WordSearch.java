package com.company.Backtracking;

public class WordSearch {

    /**
     * Given an m x n board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells, where "adjacent"
     * cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * Output: true
     *
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * Output: false
     *
     * Constraints:
     *
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 200
     * 1 <= word.length <= 103
     * board and word consists only of lowercase and uppercase English letters.
     */

    private char[][] board;
    private int ROWS;
    private int COLS;

    public WordSearch(char[][] board) {
        this.board = board;
        this.ROWS = this.board.length;
        this.COLS = this.board[0].length;
    }

    public boolean exist(String word) {
        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        // step 1 - check the bottom case
        if (index >= word.length()) {
            return true;
        }

        // step 2 - check the boundaries
        if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS ||
                this.board[row][col] != word.charAt(index)) {
            return false;
        }

        // step 3 - explore the neighbors in DFS
        boolean ret = false;

        // mark the path before the next exploration
        this.board[row][col] = '#';

        // outlines the 4 directions around a cell,
        // right, down, left, up
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret) {
                break;
            }
        }

        // step 4 - clean up and return the result
        this.board[row][col] = word.charAt(index);
        return ret;
    }

}
