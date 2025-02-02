// Simplify Path - 71

import java.util.*;

class Solution {
    
     // Simplifies a Unix-style file path by resolving '.' and '..' directories.
    public String simplifyPath(String path) {

        // Create a stack to store the directories in the simplified path
        Deque<String> stk = new ArrayDeque<>();

        // Split the input path into individual directories
        for (String s : path.split("/")) {
            // Ignore empty strings and '.' directories
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }

            // If the directory is '..', pop the last directory from the stack
            if ("..".equals(s)) {
                if (!stk.isEmpty()) {
                    stk.pollLast();
                }
            }
            // Otherwise, add the directory to the stack
            else {
                stk.offerLast(s);
            }
        }

        // Join the directories in the stack with '/' and add a leading '/'
        return "/" + String.join("/", stk);
    }
}