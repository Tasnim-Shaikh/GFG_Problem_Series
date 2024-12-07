//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array using bubble sort algorithm.
    public static void bubbleSort(int arr[]) {
        // code here
        int n=arr.length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n-1;j++){
        //         if(arr[j]>arr[j+1]){
        //             int temp=arr[j];
        //             arr[j]=arr[j+1];
        //             arr[j+1]=temp;
        //         }
        //     }
        // }
        sort(arr,n);
    }
    static void sort(int arr[],int n){
        int count=0;
        if(n==1){
            return;
        }
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    count++;
                }
            }
          if(count==0){
              return;
          }
          sort(arr,n-1);
    }
}

//{ Driver Code Starts.

class Sorting {
    // method to print the Elements of the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            // calling bubbleSort() method
            new Solution().bubbleSort(arr);

            // calling printArray() method
            printArray(arr);

            t--;
        }
    }
}
// } Driver Code Ends