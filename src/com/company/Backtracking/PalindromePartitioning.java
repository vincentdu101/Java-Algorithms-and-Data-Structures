package com.company.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome. Return all
     * possible palindrome partitioning of s.
     *
     * A palindrome string is a string that reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: s = "aab"
     * Output: [["a","a","b"],["aa","b"]]
     *
     * Example 2:
     *
     * Input: s = "a"
     * Output: [["a"]]
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 16
     * s contains only lowercase English letters.
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        depthFirstSearch(0, result, new ArrayList<>(), s);
        return result;
    }

    private static void depthFirstSearch(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start > s.length()) {
            result.add(new ArrayList<>(currentList));
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                String sub = s.substring(start, end + 1);
                System.out.println(sub);
                currentList.add(sub);
                depthFirstSearch(end + 1, result, currentList, s);

                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }

        return true;
    }

}
