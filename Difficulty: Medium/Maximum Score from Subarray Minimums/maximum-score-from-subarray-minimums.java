//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }
            int[] arr = new int[nums.size()];
            int idx = 0;
            for (int i : nums) arr[idx++] = i;
            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(arr));

            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        // int sum=0;
        // int min=Integer.MAX_VALUE;
        // int smin=Integer.MAX_VALUE;
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //         min=0;
        //         smin=0;
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]<min){
        //             smin=min;
        //             min=arr[j];
        //         } 
        //     }
        //     sum=Math.max(sum,(smin+min));
        // }
        // return sum;
        
        int maxSum = Integer.MIN_VALUE; // Initialize with the smallest possible integer
    for (int i = 0; i < arr.length - 1; i++) { // Loop through the array
        int currentSum = arr[i] + arr[i + 1]; // Calculate sum of adjacent elements
        maxSum = Math.max(maxSum, currentSum); // Update maxSum if currentSum is greater
    }
    return maxSum; 
    }
}