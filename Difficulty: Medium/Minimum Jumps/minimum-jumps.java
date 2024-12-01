//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int n=arr.length;
        if(n<=1){
            return 0;
        }
        else{
            int far=0,jump=0,curr=0;
            for(int i=0;i<n;i++){
                far=Math.max(far,arr[i]+i);
                if(i==curr){
                    curr=far;
                    jump++;
                    if(far>=n-1){
                        return jump;
                    }
                }
               
            }
            return -1;
        }
    }
}
