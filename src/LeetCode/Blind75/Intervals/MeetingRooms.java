package LeetCode.Blind75.Intervals;
import java.util.Arrays;
/*
 * PROBLEM: https://www.lintcode.com/problem/920/
 * SOLUTION: https://www.youtube.com/watch?v=PaJxqZVPhbg
 * BIG O: O(nlogn)
 */
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {

    public static boolean canAttendMeetings(Interval[] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i-1].end > intervals[i].start)
                return false;
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals1 = new Interval[3];
        intervals1[0] = new Interval(0, 30);
        intervals1[1] = new Interval(5, 10);
        intervals1[2] = new Interval(15, 20);

        Interval[] intervals2 = new Interval[2];;
        intervals2[0] = new Interval(5, 8);
        intervals2[1] = new Interval(9, 15);

        System.out.println(canAttendMeetings(intervals1)); // False
        System.out.println(canAttendMeetings(intervals2)); // True
    }
}
