//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        long fact=1;
        ArrayList<Long> arr=new ArrayList();
        
        // for(int i=1;i<=n;i++){
        //     fact=fact*i;
        //     if(fact<=n){
        //         arr.add(fact);
        //     }
        // }
        // return arr;
        // long fact = 1;
        int i = 1;
        while (fact <= n) {
            arr.add(fact);
            i++;
            fact *= i;
        }
        
        return arr;
    
    }
    
}