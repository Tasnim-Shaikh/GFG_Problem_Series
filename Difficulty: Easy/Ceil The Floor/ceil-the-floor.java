//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
    //     // code here
        Arrays.sort(arr);
        int c=findceil(arr,x);
        int f=findfloor(arr,x);
        return new int[]{f,c};
    }
    int findceil(int arr[],int x){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return ans;
    }
    int findfloor(int arr[],int x){
        int left=0;
        int right=arr.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return ans;
    }
}
