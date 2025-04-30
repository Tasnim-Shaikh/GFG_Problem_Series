//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static class pair{
        double first;
        int second;
        pair(double f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n=stations.length;
        // int diff;
        // double slen=0;
        // int hm[]=new int[n-1];
        // Arrays.fill(hm,0);
        // for(int gs=1;gs<=k;gs++){
        //     double max=-1;
        //     int index=-1;
        //     for(int i=0;i<n-1;i++){
        //          diff=stations[i+1]-stations[i];
        //          slen=diff/(double)(hm[i]+1); 
        //          if(max<slen){
        //              max=slen;
        //              index=i;
        //          }
        //     }
        //     hm[index]++;
        // }
        // double max=0;
        // for(int i=0;i<n-1;i++){
        //     diff=stations[i+1]-stations[i];
        //     slen=diff/(double)(hm[i]+1);
        //     max=Math.max(max,slen);
        // }
        // return max;
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));    
        int hm[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            pq.add(new pair(stations[i+1]-stations[i],i));
        }
        for(int gs=1;gs<=k;gs++){
            pair tp=pq.poll();
            int secind=tp.second;
            hm[secind]++;
            double diff=stations[secind+1]-stations[secind];
            double seclen=diff/(double)(hm[secind]+1);
            pq.add(new pair(seclen,secind));
        }
        return pq.peek().first;
    }
}
