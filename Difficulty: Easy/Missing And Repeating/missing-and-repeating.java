//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        // int repeat=0;
        // int max=arr[0];
        // int sum=0;
        // ArrayList<Integer> list=new ArrayList<>();
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //     sum+=arr[i];
        // }
       
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[i]==arr[j]){
        //             repeat=arr[j];
        //             break;
        //         }
        //     }
        // }
        // sum=sum-repeat;
        // int sumofn=n*(n+1)/2;
        //  int miss=sumofn-sum;
        // list.add(repeat);
        // list.add(miss);
        // return list;
        
        
        
        //Approach 1:
        // int n=arr.length;
        // int repeat=-1;
        // int missing=-1;
        // for(int i=1;i<=n;i++){
        //     int cnt=0;
        //     for(int j=0;j<n;j++){
        //         if(arr[j]==i){
        //             cnt++;
        //         }
        //     }
        //     if(cnt==2){
        //         repeat=i;
        //     }
        //     else if(cnt==0){
        //         missing=i;
        //     }
        //     if(missing!=-1 && repeat!=-1)break;
        // }
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(repeat);
        // list.add(missing);
        // return list;
        
        
        
        //Approach 2:
        int n=arr.length;
        int repeat=-1;
        int missing=-1;
        int hash[]=new int[n+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]==2){
                repeat=i;
            }
            else if(hash[i]==0){
                missing=i;
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(repeat);
        list.add(missing);
        return list;
        
        
        
    }
}
