//{ Driver Code Starts
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            double b = sc.nextDouble();
            int e = sc.nextInt();
            Solution ob = new Solution();
            System.out.printf("%.5f\n", ob.power(b, e));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    double power(double b, int e) {
        // code here
        // Base cases
        if (b == 0) return 0; // b^e is 0 if b is 0 and e > 0
        if (e == 0) return 1; // Any number raised to power 0 is 1

        // Handle negative exponent by converting to positive
        long exponent = Math.abs((long) e);
        double result = 1.0;

        // Iterative fast exponentiation
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= b;
            }
            b *= b;
            exponent >>= 1; // Divide exponent by 2
        }

        // Handle negative exponent case
        return e < 0 ? 1.0 / result : result;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends