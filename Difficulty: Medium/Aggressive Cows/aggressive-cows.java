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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n=stalls.length;
        Arrays.sort(stalls);
        int t=stalls[n-1]-stalls[0];
        for(int i=1;i<=t;i++){
            if(can_place(i,stalls,k)){
                continue;
            }
            else{
                return i-1;
            }
        }
        return t;
    }
    static boolean can_place(int d,int stalls[],int k){
        int cnt=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if((stalls[i]-last)>=d){
                cnt++;
                last=stalls[i];
            }
             if(cnt>=k){
                return true;
            }
        }
        return false;
    }
}