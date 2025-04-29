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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n=arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max)max=arr[i];
            sum+=arr[i];
        }
        if(k>n)return -1;
        //Approach 1:
        //     for(int i=max;i<=sum;i++){
        //         if(minimumpages(i,arr)<=k){
        //             return i;
        //         }
        //     }
        // return max;
        
        //Approach 2:
        int low=max;
        int high=sum;
        int re=0;
        while(low<=high){
            int mid=(low+high)/2;
            int ans=minimumpages(mid,arr);
            if(ans<=k){
                re=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return re;
    }
    static int minimumpages(int p,int arr[]){
        int stud=1;
        int pg=0;
        for(int i=0;i<arr.length;i++){
            if(pg+arr[i]<=p){
                pg+=arr[i];
            }
            else{
                stud++;
                pg=arr[i];
            }
        }
        return stud;
    }
}