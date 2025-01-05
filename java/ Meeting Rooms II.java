/*
 * Meeting Rooms II - 253
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        // Create a list to hold the start and end times
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        // Populate the start and end times
        for (Interval interval : intervals) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        // Sort the start and end times
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int roomCount = 0;
        int endPointer = 0;

        // Iterate through the start times
        for (int startPointer = 0; startPointer < startTimes.size(); startPointer++) {
            // If a meeting starts after the last meeting ends, we can reuse a room
            if (startTimes.get(startPointer) >= endTimes.get(endPointer)) {
                endPointer++; // Move to the next meeting that has ended
            } else {
                roomCount++; // We need a new room
            }
        }

        return roomCount;
    }
}