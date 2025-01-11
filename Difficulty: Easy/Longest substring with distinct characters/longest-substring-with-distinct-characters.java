//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
    int maxLength = 0;

    // Create a set to store characters in the current window
    HashSet<Character> charSet = new HashSet<>();

    // Two pointers to define the window
    int left = 0, right = 0;

    while (right < n) {
        // If the character is not in the set, add it and move the right pointer
        if (!charSet.contains(s.charAt(right))) {
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        } else {
            // If the character is already in the set, remove the leftmost character
            charSet.remove(s.charAt(left));
            left++;
        }
    }

    return maxLength;
    }
}