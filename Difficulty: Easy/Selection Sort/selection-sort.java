//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }

            Solution obj = new Solution();
            obj.selectionSort(a);

            IntArray.print(a);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    void selectionSort(int[] arr) {
        // code here
        int n=arr.length;
        // for(int i=0;i<n;i++){
        //     int k=0;
        //     int last=n-i-1;
        //     for(int j=0;j<=last;j++){
        //         if(arr[j]>arr[k]){
        //             k=j;
        //         }
        //     }
        //     int temp=arr[k];
        //     arr[k]=arr[last];
        //     arr[last]=temp;
        // }
        
        for(int i=0;i<n;i++){
            int k=i;
            for(int j=i;j<n;j++){
                if(arr[k]>arr[j]){
                    k=j;
                }
            }
            int temp=arr[k];
            arr[k]=arr[i];
            arr[i]=temp;
        }
    }
}