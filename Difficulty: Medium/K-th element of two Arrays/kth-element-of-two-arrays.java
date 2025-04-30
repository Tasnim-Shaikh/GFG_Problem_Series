//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
         int n1=a.length;
          int n2=b.length;
          int i=0;
          int j=0;
          int cnt=1;
          int ele=-1;
          while(i<n1 && j<n2){
            if(a[i]<b[j]){
                if(cnt==k)ele=a[i];
                i++;
                cnt++;
            }
            else{
                if(cnt==k)ele=b[j];
                j++;
                cnt++;
            }
          }
          while(i<n1){
             if(cnt==k)ele=a[i];
                i++;
                cnt++;
          }
          while(j<n2){
             if(cnt==k)ele=b[j];
                j++;
                cnt++;
          }
        return ele;
    }
}