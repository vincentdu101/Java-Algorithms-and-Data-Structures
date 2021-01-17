package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * Example 1:
     *
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     *
     * Example 2:
     *
     * Input: n = 1
     * Output: ["()"]
     *
     *
     * Constraints:
     *
     * 1 <= n <= 8
     */

    /**
     * Solution
     * Intuition and Algorithm
     *
     * Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it
     * will remain a valid sequence. We can do this by keeping track of the number of opening and closing
     * brackets we have placed so far.
     *
     * We can start an opening bracket if we still have one (of n) left to place. And we can start a
     * closing bracket if it would not exceed the number of opening brackets.
     *
     * https://leetcode.com/problems/generate-parentheses/solution/
     */
    public static List<String> generate(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            System.out.println("open = " + (open + 1) + " close = " + close + " " + cur + "(");
            backtrack(ans, cur + "(", open + 1, close, max);
        }

        if (close < open) {
            System.out.println("open = " + open + " close = " + (close + 1) + " " + cur + ")");
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }

}
