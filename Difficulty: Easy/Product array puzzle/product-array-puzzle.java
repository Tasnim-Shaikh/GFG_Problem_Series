//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
          int n = arr.length;
        int[] res = new int[n];
        
        // Edge case: If the size of the array is less than 2
        if (n < 2) {
            return res;
        }

        // Create arrays for prefix and suffix products
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Initialize prefix and suffix arrays
        prefix[0] = 1;
        suffix[n - 1] = 1;

        // Fill prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        // Fill suffix array
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        // Compute the result array
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}
