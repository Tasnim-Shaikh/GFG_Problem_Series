//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
     public ArrayList<String> findPermutation(String s) {
        // List to store the unique permutations
        ArrayList<String> result = new ArrayList<>();
        // Convert string to character array for easier swapping
        char[] chars = s.toCharArray();
        // Sort the characters to handle duplicates more efficiently
        Arrays.sort(chars);
        // Backtracking function call
        boolean[] used = new boolean[chars.length];
        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }

    private void backtrack(char[] chars, StringBuilder current, boolean[] used, ArrayList<String> result) {
        // If the current permutation is complete, add to the result list
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters or duplicate characters in the same depth level
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }

            // Mark the character as used
            used[i] = true;
            current.append(chars[i]);
            // Recursively build the permutation
            backtrack(chars, current, used, result);
            // Backtrack by removing the last added character
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

}