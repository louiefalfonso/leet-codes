/*
 * Meeting Rooms - 252
 */

 import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort the intervals based on the start time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        // Check for overlaps
        for (int i = 1; i < intervals.size(); i++) {
            // If the start time of the current interval is less than the end time of the
            // previous interval
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false; // There is an overlap
            }
        }

        return true; // No overlaps found
    }
}
