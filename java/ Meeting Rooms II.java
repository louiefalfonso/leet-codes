/*
 * Meeting Rooms II - 253
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    
    public int minMeetingRooms(List<Interval> intervals) {
        // Handle edge case where there are no meetings
        if (intervals.isEmpty()) {
            return 0;
        }

        // Create separate lists to hold start and end times for easier sorting
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // Populate start and end times from the intervals
        for (Interval interval : intervals) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        // Sort start and end times in ascending order
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        // Initialize variables to keep track of room count and end pointer
        int roomCount = 0;
        int endPointer = 0;

        // Iterate through the start times to determine room requirements
        for (int startPointer = 0; startPointer < startTimes.size(); startPointer++) {
            // If a meeting starts after the last meeting ends, we can reuse a room
            if (startTimes.get(startPointer) >= endTimes.get(endPointer)) {
                // Move to the next meeting that has ended
                endPointer++;
            } else {
                // We need a new room, increment room count
                roomCount++;
            }
        }

        // Return the minimum number of rooms required
        return roomCount;
    }
}