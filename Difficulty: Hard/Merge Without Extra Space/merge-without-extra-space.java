//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {
            String arr1[] = br.readLine().trim().split(" ");
            String arr2[] = br.readLine().trim().split(" ");

            int a[] = new int[arr1.length];
            int b[] = new int[arr2.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);
            for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(arr2[i]);

            Solution ob = new Solution();
            ob.mergeArrays(a, b);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < a.length; i++) {
                str.append(a[i] + " ");
            }
            System.out.println(str);
            str = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                str.append(b[i] + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n1=a.length;
        int n2=b.length;
        int size=n1+n2;
        int arr[]=new int[size];
        int i=0;
        for(int n:a){
            arr[i]=n;
            i++;
        }
        for(int n:b){
            arr[i]=n;
            i++;
        }
        Arrays.sort(arr);
        for(int j=0;j<a.length;j++){
            a[j]=arr[j];
        }
        int m=a.length;
        for(int j=0;j<b.length;j++){
            b[j]=arr[m];
            m++;
        }
        
    }
}
