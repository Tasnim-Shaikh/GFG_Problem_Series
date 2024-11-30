//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int A = Integer.parseInt(S[0]); // Corrected parseInt
            int B = Integer.parseInt(S[1]); // Corrected parseInt

            Solution ob = new Solution();
            int[] ptr = ob.lcmAndGcd(A, B);

            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int[] lcmAndGcd(int a, int b) {
        // code here
        int no;
        if(a<b){
            no=a;
        }
        else{
            no=b;
        }
        int divisor=0;
        for(int i=1;i<=no;i++){
            if(a%i==0 && b%i==0){
                divisor=i;
            }
        }
        int r1=a/divisor;
        int r2=b/divisor;
        int lcm=divisor*r1*r2;
        return new int[]{lcm,divisor};
    }
};