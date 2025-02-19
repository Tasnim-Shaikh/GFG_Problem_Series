//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores the lower half (max heap)
    private PriorityQueue<Integer> minHeap; // Stores the upper half (min heap)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Insert into max heap
        maxHeap.add(num);
        
        // Step 2: Balance - Ensure maxHeap's top is <= minHeap's top
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }

        // Step 3: Maintain size property
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

class Solution {
   public static ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> result = new ArrayList<>();
        MedianFinder medianFinder = new MedianFinder();

        for (int num : arr) {
            medianFinder.addNum(num);
            result.add(medianFinder.findMedian());
        }
        return result;
    }
}