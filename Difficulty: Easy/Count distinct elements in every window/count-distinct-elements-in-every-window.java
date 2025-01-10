//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        // HashMap to store the frequency of elements in the current window
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Add the count of distinct elements in the first window
        result.add(map.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the first element of the previous window
            int prevElement = arr[i - k];
            if (map.get(prevElement) == 1) {
                map.remove(prevElement);
            } else {
                map.put(prevElement, map.get(prevElement) - 1);
            }

            // Add the new element to the current window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Add the count of distinct elements in the current window
            result.add(map.size());
        }

        return result;
    }
}
