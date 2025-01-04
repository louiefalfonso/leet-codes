/*
 * LRU Cache - 146
 */
import java.util.*;

 // Node class to represent a node in the doubly linked list
class Node {
    int key, val; // key and value of the node
    Node prev, next; // previous and next nodes in the list

    // Default constructor
    Node() {
    }

    // Constructor to initialize the node with key and value
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// LRUCache class to implement the LRU cache
class LRUCache {
    // Size of the cache
    private int size;
    // Capacity of the cache
    private int capacity;
    // Head and tail nodes of the doubly linked list
    private Node head = new Node();
    private Node tail = new Node();
    // Map to store the nodes for O(1) access
    private Map<Integer, Node> cache = new HashMap<>();

    // Constructor to initialize the cache with the given capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Initialize the head and tail nodes
        head.next = tail;
        tail.prev = head;
    }

    // Method to get the value of the node with the given key
    public int get(int key) {
        // If the key is not in the cache, return -1
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Get the node from the cache
        Node node = cache.get(key);
        // Remove the node from its current position
        removeNode(node);
        // Add the node to the head of the list (most recently used)
        addToHead(node);
        // Return the value of the node
        return node.val;
    }

    // Method to put a new node with the given key and value into the cache
    public void put(int key, int value) {
        // If the key is already in the cache, update its value
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Remove the node from its current position
            removeNode(node);
            // Update the value of the node
            node.val = value;
            // Add the node to the head of the list (most recently used)
            addToHead(node);
        } else {
            // Create a new node with the given key and value
            Node node = new Node(key, value);
            // Add the node to the cache
            cache.put(key, node);
            // Add the node to the head of the list (most recently used)
            addToHead(node);
            // If the cache is full, remove the least recently used node
            if (++size > capacity) {
                // Get the least recently used node (tail.prev)
                node = tail.prev;
                // Remove the node from the cache
                cache.remove(node.key);
                // Remove the node from the list
                removeNode(node);
                // Decrement the size of the cache
                --size;
            }
        }
    }

    // Method to remove a node from the list
    private void removeNode(Node node) {
        // Update the previous and next nodes to skip the current node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Method to add a node to the head of the list
    private void addToHead(Node node) {
        // Update the previous and next nodes to add the current node
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}
