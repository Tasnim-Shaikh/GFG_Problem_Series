//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int arr[][]) {
        // code here
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

    int removals = 0;
    int prevEnd = arr[0][1];

    // Traverse intervals starting from the second one
    for (int i = 1; i < arr.length; i++) {
        if (arr[i][0] < prevEnd) {
            // Overlapping interval found, increment removal count
            removals++;
            // Keep the interval with the smaller end time
            prevEnd = Math.min(prevEnd, arr[i][1]);
        } else {
            // Update prevEnd to the end of the current non-overlapping interval
            prevEnd = arr[i][1];
        }
    }

    return removals;
    }
}
