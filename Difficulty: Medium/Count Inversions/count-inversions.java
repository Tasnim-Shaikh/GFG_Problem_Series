//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
       // Your Code Here
      int n=arr.length;
    //   int count=0;
    //   for(int i=0;i<n;i++){
    //       for(int j=i+1;j<n;j++){
    //           if(arr[i]>arr[j] && i<j){
    //               count++;
    //           }
    //       }
    //   }
    //     return count;
    
        return mergesort(arr,0,n-1);
    }
    static int mergesort(int arr[],int low,int high){
        int count=0;
        if(low>=high){
            return count;
        }
        int mid=(low+high)/2;
        count+=mergesort(arr,low,mid);
        count+=mergesort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }
    static int merge(int arr[],int low,int mid,int high){
        ArrayList<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;
        int count=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
            temp.add(arr[left]);
            left++;
        }
        else {
            temp.add(arr[right]);
            count+=(mid-left+1);
            right++;
        }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }
        return count;
    }
}