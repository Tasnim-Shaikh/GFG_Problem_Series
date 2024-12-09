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
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int arr[][]=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals[i].length;j++){
                arr[i][j]=intervals[i][j];
            }
        }
        arr[intervals.length][0]=newInterval[0];
       arr[intervals.length][1]=newInterval[1];
      Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
       ArrayList<int[]> merged = new ArrayList<>();

        for (int[] n : arr) {
            // If the merged list is empty or the current interval does not overlap with the previous one
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < n[0]) {
                merged.add(n); // Add the current interval
            } else {
                // Merge the current interval with the previous one
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], n[1]);
            }
        }

        return merged;
    }
}
