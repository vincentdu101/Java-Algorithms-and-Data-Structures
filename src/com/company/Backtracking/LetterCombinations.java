package com.company.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 Example 1:

 Input: digits = "23"
 Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 Example 2:

 Input: digits = ""
 Output: []
 Example 3:

 Input: digits = "2"
 Output: ["a","b","c"]

 Constraints:

 0 <= digits.length <= 4
 digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinations {

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    static List<String> output = new ArrayList<>();

    public static List<String> generate(String digits) {
        output = new ArrayList<>();

        if (digits.length() > 0) {
            backtrack("", digits);
        }

        return output;
    }

    private static void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            // if there is no more digits to check
            output.add(combination);
        } else {
            // there are still more digits to check
            // iterate over all letters which map
            // the next available digit
            int beginIndex = 0;
            int endIndex = 1;
            // gets the character (1 character)
            String digit = nextDigits.substring(beginIndex, endIndex);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i+1);

                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}
