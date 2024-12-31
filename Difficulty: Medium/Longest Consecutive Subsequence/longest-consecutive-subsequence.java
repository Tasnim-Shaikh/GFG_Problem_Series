//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        // int smallest=arr[0];
        // for(int n:arr){
        //     if(n<smallest){
        //         smallest=n;
        //     }
        // }
        ArrayList<Integer> arrlist=new ArrayList<>();
        for(int n:arr){
            arrlist.add(n);
        }
        HashSet<Integer>hash=new HashSet<>();
        int count=0;
        // ArrayList<Integer> list=new ArrayList<>();
        // for(int i=smallest;i<999;i++){
        //     if(arrlist.contains(i)){
        //         list.add(i);
        //     }
        //     else{
        //         break;
        //     }
        // }
        // return list.size();
        for(int i=0;i<arr.length;i++){
            count=0;
            for(int j=0;j<999;j++){
                if(arrlist.contains((arr[i]+j))){
                    count++;
                }
                else{
                    break;
                }
            }
            hash.add(count);
        }
        int big=0;
        for(int n:hash){
            if(n>big){
                big=n;
            }
        }
        return big;
    }
}