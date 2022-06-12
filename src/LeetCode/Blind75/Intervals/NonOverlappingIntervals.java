package LeetCode.Blind75.Intervals;
import java.util.Arrays;
/*
 * PROBLEM: https://leetcode.com/problems/non-overlapping-intervals/
 * SOLUTION: https://www.youtube.com/watch?v=nONCGxWoUfM
 * BIG O: O(nlogn)
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return 0;

        int intervalsRemoved = 0;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] firstInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (firstIntervalWithinSecond(firstInterval, intervals[i])) {
                // Mark the first interval to be removed
                intervalsRemoved++;
                // Determine which interval to remove
                // Remove the interval that ends last
                if (firstInterval[1] > intervals[i][1]) {
                    firstInterval = intervals[i];
                }
            } else {
                firstInterval = intervals[i];
            }
        }

        return intervalsRemoved;
    }

    public static boolean firstIntervalWithinSecond(int[] intervalFirst, int[] intervalSecond){
        return intervalSecond[0] < intervalFirst[1];
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(input));
    }
}
