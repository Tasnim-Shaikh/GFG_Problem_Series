//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Complete the function
         int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                if (arr[left] == arr[right]) {
                    // If all numbers between left and right are the same
                    int numElements = right - left + 1;
                    count += (numElements * (numElements - 1)) / 2; // Combination formula: nC2 = n * (n-1) / 2
                    break;
                } else {
                    // Count duplicates on the left
                    int leftCount = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    // Count duplicates on the right
                    int rightCount = 1;
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    // Add pair combinations
                    count += leftCount * rightCount;

                    // Move pointers
                    left++;
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}

//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends