//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
          int n = arr.length;

        // If the number of students is more than the number of books, allocation is not possible
        if (k > n) {
            return -1;
        }

        int low = Integer.MIN_VALUE; // Minimum possible value (max pages in a single book)
        int high = 0; // Sum of all pages

        for (int pages : arr) {
            low = Math.max(low, pages); // The minimum value in binary search
            high += pages; // The maximum value in binary search
        }

        int result = -1;

        // Binary search to find the minimum maximum number of pages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasible(arr, n, k, mid)) {
                result = mid; // Update result to current mid
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }

    private static boolean isFeasible(int[] arr, int n, int k, int mid) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > mid) {
                return false; // If a single book has more pages than mid, allocation is not possible
            }

            if (currentSum + arr[i] > mid) {
                // Assign to a new student
                studentsRequired++;
                currentSum = arr[i];

                if (studentsRequired > k) {
                    return false; // More students required than available
                }
            } else {
                currentSum += arr[i];
            }
        }

        return true;
    }
    
}