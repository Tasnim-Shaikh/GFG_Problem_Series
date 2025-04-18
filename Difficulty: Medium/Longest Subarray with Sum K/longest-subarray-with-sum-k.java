//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
    //Approach 2:Better
       HashMap<Integer, Integer> map = new HashMap<>();
        int len=0;
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){
                len=Math.max(len,i+1);
            }
            int rem=sum-k;
            if(map.containsKey(rem)){
                int r=i-map.get(rem);
                len=Math.max(len,r);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;
    }
}
