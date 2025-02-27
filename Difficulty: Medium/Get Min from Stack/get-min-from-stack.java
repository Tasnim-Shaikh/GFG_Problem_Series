//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public Solution() {}

    // Add an element to the top of Stack
    private Stack<Integer> mainStack=new Stack<>();
    private Stack<Integer> minStack=new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        // Push to minStack if it's empty or x is the new minimum
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int removed = mainStack.pop();
            // Remove from minStack if it's the minimum value
            if (!minStack.isEmpty() && removed == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int peek() {
        return mainStack.isEmpty() ? -1 : mainStack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}