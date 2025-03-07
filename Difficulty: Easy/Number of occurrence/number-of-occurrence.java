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
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        //Approach 1:
        // int count=0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]==target){
        //         count++;
        //     }
        // }
        // return count;
        
        
        //Approach 2:
        int c=findceil(arr,target);
        int f=0;
        if(c!=-1){
            f=findfloor(arr,target);
        }
           else{
               return 0;
           }
        
        return (c-f)+1;
    }
    int findceil(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                ans=mid;
                left=mid+1;
            }
            else if(target>arr[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
    int findfloor(int arr[],int target){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                ans=mid;
                right=mid-1;
            }
            else if(target>arr[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}
