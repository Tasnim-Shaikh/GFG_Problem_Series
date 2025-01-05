//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
       int n = arr.length;
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {

            // Use binary search in arr[i+1...n-1] to  
            // find the element closest to (target - arr[i])
            int complement = target - arr[i];
            int closest = findClosest(arr, i + 1, n - 1, complement);

            int currDiff = Math.abs(target - arr[i] - closest);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = Arrays.asList(arr[i], closest);
            }
        }

        return res;
    }
    // Find element closest to complement using binary search
    static int findClosest(int[] arr, int lo, int hi, int complement) {
        int res = arr[lo];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            // Update answer if we find a closer element
            if (Math.abs(arr[mid] - complement) < Math.abs(res - complement))
                res = arr[mid];
      
            // If there is a tie, then we pick the larger value
            else if (Math.abs(arr[mid] - complement) == Math.abs(res - complement))
                res = Math.max(res, arr[mid]);
        
            if (arr[mid] == complement)
                return arr[mid];
            else if (arr[mid] < complement)
                lo = mid + 1;
            else 
                hi = mid - 1;
        }

        return res;
    }
}