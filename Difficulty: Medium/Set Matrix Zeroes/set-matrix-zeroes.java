//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    traverse_row(i,m,mat);
                    traverse_column(j,n,mat);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==99999){
                    mat[i][j]=0;
                }
            }
        }
    }
    void traverse_row(int i,int m,int [][]mat){
        for(int j=0;j<m;j++){
            if(mat[i][j]!=0){
                mat[i][j]=99999;
            }
        }
    }
    void traverse_column(int i,int n,int [][]mat){
        for(int j=0;j<n;j++){
            if(mat[j][i]!=0){
                mat[j][i]=99999;
            }
        }
    }
}