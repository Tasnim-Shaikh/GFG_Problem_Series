//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int T = sc.nextInt();
        while (T-- > 0) {
            // creating an object of class Print
            Solution obj = new Solution();
            int N;

            // input N
            N = sc.nextInt();

            // calling printNos() methdo
            // of class Print
            obj.printNos(N);
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




//User function Template for Java



class Solution
{
    
  public void printNos(int N)
    {
        if(N==1){
            System.out.print("1 ");
          
        }
        else{
             printNos(N-1);
               System.out.print(N+" ");
        }
        //printhelper(N,1);
    }
    // public void printhelper(int N,int current){
    //     if(current>N){
    //         return;
    //     }
    //     else{
    //         System.out.print(current+" ");
    //         printhelper(N,current+1);
    //     }
    // }
}

