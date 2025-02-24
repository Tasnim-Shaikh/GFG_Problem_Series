//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
class Solution {
    int maxLen(int arr[]) {
        // code here
        int n=arr.length;
        int max=0;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
                sum+=arr[i];
                if(sum==0){
                     max=i+1;
                }
                else{
                    if(map.containsKey(sum)){
                        max=Math.max(max,i-(map.get(sum)));
                    }
                    else{
                        map.put(sum,i);
                    }
                }
        }
        return max;
    }
}
