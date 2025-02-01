//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt(); // Number of test cases
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] mat = new char[n][m];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.next().charAt(0);
                }
            }

            String word = sc.next();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(mat, word);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
     private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    static public boolean isWordExist(char[][] mat, String word) {
        if (mat == null || mat.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int n = mat.length;
        int m = mat[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the first character matches, start the search
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] mat, int i, int j, String word, int index) {
        // If the entire word is matched
        if (index == word.length()) {
            return true;
        }

        // Check if the current cell is out of bounds or doesn't match the current character
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(index)) {
            return false;
        }

        // Temporarily mark the current cell as visited by changing its value
        char temp = mat[i][j];
        mat[i][j] = '#';

        // Explore all four possible directions
        for (int dir = 0; dir < 4; dir++) {
            int newRow = i + rowDir[dir];
            int newCol = j + colDir[dir];

            if (dfs(mat, newRow, newCol, word, index + 1)) {
                return true;
            }
        }

        // Backtrack: restore the original value of the cell
        mat[i][j] = temp;

        return false;
    }
    
}