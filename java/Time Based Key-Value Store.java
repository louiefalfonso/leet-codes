// Time Based Key-Value Store - 981

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {
    // Using a Map where each key is a string and its value is a TreeMap that
    // associates timestamps with values
    private Map<String, TreeMap<Integer, String>> keyTimeValueMap = new HashMap<>();

    /**
     * Initializes the TimeMap object.
     */
    public TimeMap() {
        // Constructor does not need to initialize anything since the HashMap is already
        // initialized.
    }

    /**
     * Stores the key with the value along with the given timestamp.
     *
     * @param key       the key to store
     * @param value     the value associated with the key
     * @param timestamp the timestamp at which the value is set for the key
     */
    public void set(String key, String value, int timestamp) {
        // Compute if absent will insert a new TreeMap if the key is not already present
        // It then puts the given timestamp and value into the TreeMap for the given key
        keyTimeValueMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    
    public String get(String key, int timestamp) {
        // If the key does not exist, return an empty string
        if (!keyTimeValueMap.containsKey(key)) {
            return "";
        }
        // Retrieve the TreeMap for the given key
        TreeMap<Integer, String> timeValueMap = keyTimeValueMap.get(key);
        // Find the greatest timestamp less than or equal to the given timestamp
        Integer closestTimestamp = timeValueMap.floorKey(timestamp);
        // If there is no timestamp that is less than or equal to the given timestamp,
        // return an empty string
        // Otherwise, return the associated value
        return closestTimestamp == null ? "" : timeValueMap.get(closestTimestamp);
    }
}