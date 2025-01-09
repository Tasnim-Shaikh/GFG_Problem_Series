//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            Solution ob = new Solution();
            int ans = ob.sumOfDivisors(N);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int sumOfDivisors(int n) {
        // code here
        int result=0;
        for(int i=1;i<=n;i++){
            result+=find_divisor(i);
        }
         return result;
    }
    static int find_divisor(int n){
         int sum=0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                sum+=i;
                if((n/i)!=i){
                    sum+=(n/i);
                }
            }
        }
        return sum;
    }
}