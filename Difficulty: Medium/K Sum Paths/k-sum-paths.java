//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int sumK(Node root, int k) {
        // HashMap to store prefix sums and their frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Initialize with 0 sum path
        return countPaths(root, 0, k, prefixSumMap);
    }

    private int countPaths(Node node, int currentSum, int target, HashMap<Integer, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        // Update the current sum
        currentSum += node.data;

        // Find the number of paths ending at this node that sum to the target
        int numPaths = prefixSumMap.getOrDefault(currentSum - target, 0);

        // Update prefix sum map
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);

        // Recurse for left and right subtrees
        numPaths += countPaths(node.left, currentSum, target, prefixSumMap);
        numPaths += countPaths(node.right, currentSum, target, prefixSumMap);

        // Remove the current sum from the map to avoid affecting other paths
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);

        return numPaths;
    }
}