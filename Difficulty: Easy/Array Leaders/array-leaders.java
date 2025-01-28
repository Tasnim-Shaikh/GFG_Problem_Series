//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            List<Integer> result = new Solution().leaders(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();    // Ensure new line after each test case output
                System.out.println("~"); // Ensure new line after each test case output
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        //Approach 1:Brute Force
        ArrayList<Integer> list=new ArrayList<>();
        int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         boolean leader=true;
    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]>arr[i]){
    //                 leader=false;
    //             }
    //         }
    //         if(leader){
    //             list.add(arr[i]);
    //         }
    //     }
    //     return list;
    
    
    //Approach 2:Optimal
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
          if(arr[i]>=max){
              max=arr[i];
              list.add(arr[i]);
          }  
        }
        Collections.reverse(list);
        return list;
    }
}
