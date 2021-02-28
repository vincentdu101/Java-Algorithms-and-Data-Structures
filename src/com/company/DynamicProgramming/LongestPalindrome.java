package com.company.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * Example 3:
     *
     * Input: s = "a"
     * Output: "a"
     * Example 4:
     *
     * Input: s = "ac"
     * Output: "a"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters (lower-case and/or upper-case),
     */

    public static String generate(String s) {

        // if empty string or just one character, then just
        // return it
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }

        if (isPalindrome(s)) {
            return s;
        }

        // with each character as a starting point,
        // figure out the longest palindrome string it
        // can form
        List<String> output = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            determinePalindrome(s, i, output);
        }

        // find the longest string stored
        String longest = "";
        for (String out : output) {
            if (out.length() > longest.length()) {
                longest = out;
            }
        }

        return longest;
    }

    // figure out the palindrome combinations possible
    // in the string
    private static void determinePalindrome(String s, int index, List<String> output) {
        String letter = "";

        for (int i = index; i < s.length(); i++) {
            letter += s.charAt(i);
            // if a word combination is a palindrome then we will add it
            // to the list, because the word is partially formed each time
            // we have to go the very end before we can completely cross
            // it off as done
            if (isPalindrome(letter)) {
                output.add(letter);
            }
        }
    }

    // given a word, we try to see if it is a palindrome
    private static boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
