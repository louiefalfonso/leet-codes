// Task Scheduler - 621

class Solution {
    
    //Returns the least number of units of time that the CPU will take to finish
    public int leastInterval(char[] tasks, int n) {
        // Create a frequency array to count the occurrences of each task.
        int[] cnt = new int[26];

        // Initialize the maximum frequency and iterate through the tasks.
        int x = 0;
        for (char c : tasks) {
            // Convert the character to its corresponding index in the frequency array.
            c -= 'A';
            ++cnt[c];
            // Update the maximum frequency.
            x = Math.max(x, cnt[c]);
        }

        // Count the number of tasks with the maximum frequency.
        int s = 0;
        for (int v : cnt) {
            if (v == x) {
                ++s;
            }
        }

        // Calculate the least number of units of time.
        // The formula is based on the fact that we need to insert (x - 1) * (n + 1)
        // units of idle time
        // to separate the tasks with the maximum frequency, and then add the remaining
        // tasks.
        return Math.max(tasks.length, (x - 1) * (n + 1) + s);
    }
}