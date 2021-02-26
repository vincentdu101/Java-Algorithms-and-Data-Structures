package com.company.Stack;

import com.company.Backtracking.PalindromePartitioning;

import java.util.Stack;

public class Problems {

    /**
     * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
     *
     * In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves
     * the directory up a level.
     *
     * Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash '/'
     * between two directory names. The last directory name (if it exists) must not end with a trailing '/'. Also, the canonical
     * path must be the shortest string representing the absolute path.
     *
     *
     * Example 1:
     *
     * Input: path = "/home/"
     * Output: "/home"
     * Explanation: Note that there is no trailing slash after the last directory name.
     *
     * Example 2:
     *
     * Input: path = "/../"
     * Output: "/"
     * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
     *
     * Example 3:
     *
     * Input: path = "/home//foo/"
     * Output: "/home/foo"
     * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
     *
     * Example 4:
     *
     * Input: path = "/a/./b/../../c/"
     * Output: "/c"
     *
     * Constraints:
     *
     * 1 <= path.length <= 3000
     * path consists of English letters, digits, period '.', slash '/' or '_'.
     * path is a valid Unix path.
     */
    public static String simplifyPath(String path) {
        // initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {

            // a no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                // if the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // finally a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // stitch together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}
