//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // Your code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        // Arrays to store previous and next smaller elements
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Compute Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack for next smaller element calculation
        stack.clear();

        // Compute Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Create an array to store results of min values for each window size
        int[] maxMin = new int[n + 1]; // Using n+1 to handle indexing easily

        // Process each element and determine the window size where it is the minimum
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            maxMin[windowSize] = Math.max(maxMin[windowSize], arr[i]);
        }

        // Fill the result array by propagating max values to smaller window sizes
        for (int i = n - 1; i >= 1; i--) {
            maxMin[i] = Math.max(maxMin[i], maxMin[i + 1]);
        }

        // Convert to ArrayList
        for (int i = 1; i <= n; i++) {
            result.set(i - 1, maxMin[i]);
        }

        return result;
    }
}