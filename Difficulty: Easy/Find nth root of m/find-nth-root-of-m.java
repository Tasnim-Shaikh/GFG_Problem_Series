//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(n==1)return m;
        for(int i=1;i<=m;i++){
            int ans=func(i,n);
            if(m==ans){
                return i;
            }
            else if(ans>m)return -1;
        }
        return -1;
    }
    int func(int i,int n){
        int ans=1;
        while(n>0){
            ans*=i;
            n--;
        }
        return ans;
    }
}