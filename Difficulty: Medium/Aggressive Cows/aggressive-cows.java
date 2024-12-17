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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls); // Step 1: Sort the stalls
        
        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = 0; // To store the final answer
        
        while (low <= high) {
            int mid = (low + high) / 2; // Middle distance to test
            
            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result if placement is possible
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the distance
            }
        }
        
        return result; // Return the maximum possible minimum distance
    }
    
    // Function to check if cows can be placed with minimum distance 'dist'
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // First cow is placed in the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update the last position
                
                if (count >= k) { // All cows are placed successfully
                    return true;
                }
            }
        }
        
        return false; // Not enough cows placed
    }
    
}