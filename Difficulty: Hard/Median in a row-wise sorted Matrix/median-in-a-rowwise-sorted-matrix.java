//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int median(int mat[][]) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,mat[i][0]);
            max=Math.max(max,mat[i][m-1]);
        }
        int low=min;
        int high=max;
        int req=(n*m)/2;
        while(low<=high){
            int mid=(low+high)/2;
            int cntelement=findrequire(mat,mid,n);
            if(cntelement<=req){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    int findrequire(int mat[][],int d,int n){
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt+=upperbound(mat[i],d);
        }
        return cnt;
    }
    int upperbound(int mat[],int d){
        int low=0;
        int high=mat.length-1;
        int ans=mat.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[mid]>d){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}