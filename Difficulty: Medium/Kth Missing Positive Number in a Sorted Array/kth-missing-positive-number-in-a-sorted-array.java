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
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        ArrayList<Integer> missarr=new ArrayList<Integer>();
        int m=0;
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]!=i+1&&m<k+1){
        //         missarr[m]=i+1;
        //         m++;
        //     }
        // }
        // int r=missarr[missarr.length-1];
        // return r;
        HashSet<Integer> map=new HashSet<>();
        for(int n:arr){
            map.add(n);
        }
        int n=arr[arr.length-1];
        for(int i=1;i<=n;i++){
            if(!map.contains(i)){
                missarr.add(i);
            }
        }
    //   System.out.println(Arrays.toString(missarr));
    if(missarr.size()==0){
        return k+arr.length;
    }
    else{
        if(k>missarr.size()){
            return arr[arr.length-1]+k-missarr.size();
        }
        else{
            return missarr.get(k-1);
        }
    }
    }
}