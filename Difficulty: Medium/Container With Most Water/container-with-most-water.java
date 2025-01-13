//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
         int left = 0;
        int right = arr.length - 1;
        
        // Variable to store the maximum water
        int maxWater = 0;
        
        // Iterate while left pointer is less than right pointer
        while (left < right) {
            // Calculate the width of the container
            int width = right - left;
            
            // Calculate the height of the container (minimum of the two heights)
            int height = Math.min(arr[left], arr[right]);
            
            // Calculate the water contained
            int currentWater = width * height;
            
            // Update the maximum water if the current water is greater
            maxWater = Math.max(maxWater, currentWater);
            
            // Move the pointer pointing to the smaller height
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}