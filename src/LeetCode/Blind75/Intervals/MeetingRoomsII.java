package LeetCode.Blind75.Intervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * PROBLEM: https://www.lintcode.com/problem/919/
 * SOLUTION: https://www.youtube.com/watch?v=FdzJmTCVyJU
 * BIG O: O(nlogn)
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(List<Interval> intervals) {
        int[] startTimes = new int[intervals.size()]; // Holds all meeting start times
        int[] endTimes = new int[intervals.size()]; // Holds all meeting end times
        // Loop through intervals and store meeting starting and ending times
        for (int i = 0; i < intervals.size(); i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }
        // Sort the start and end times in ascending order
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        // Store the meeting rooms and current count
        int meetingRooms = 0, count = 0;
        // Store the pointers for the 'startTimes' and 'endTimes' array
        int s = 0, e = 0;
        // Loop through both arrays with two pointers
        while (s < intervals.size()) {
            if (startTimes[s] < endTimes[e]) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count -= 1;
            }
            meetingRooms = Math.max(meetingRooms, count);
        }

        return meetingRooms;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(0, 30));
        input.add(new Interval(5, 10));
        input.add(new Interval(15, 20));

        System.out.println(minMeetingRooms(input));
    }
}
