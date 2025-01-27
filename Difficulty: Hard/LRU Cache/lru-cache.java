//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
     class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of the cache
    private final Map<Integer, Node> map; // HashMap to store key-node pairs
    private final Node head, tail; // Dummy head and tail for the doubly linked list

    // Constructor for initializing the cache capacity with the given value
    public LRUCache(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not found
        }
        // Move the accessed node to the front (most recently used)
        Node node = map.get(key);
        remove(node);
        addToFront(node);
        return node.value;
    }

    // Function for storing key-value pair
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Key already exists, update the value and move it to the front
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            // If capacity is reached, remove the least recently used node
            if (map.size() == capacity) {
                Node lru = tail.prev; // Least recently used node
                remove(lru);
                map.remove(lru.key);
            }
            // Add the new key-value pair
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Helper function to remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper function to add a node to the front of the doubly linked list
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
