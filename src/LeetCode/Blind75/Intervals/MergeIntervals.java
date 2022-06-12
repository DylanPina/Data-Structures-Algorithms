package LeetCode.Blind75.Intervals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * PROBLEM: https://leetcode.com/problems/merge-intervals/
 * SOLUTION: https://www.youtube.com/watch?v=qKczfGUrFY4
 * BIG O: O(nlogn)
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
       if (intervals.length <= 1)
           return intervals;

       // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] newInterval = intervals[0];
        mergedIntervals.add(newInterval);
        for (int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to list
                newInterval = interval;
                mergedIntervals.add(newInterval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] interval : merge(input))
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        System.out.println();
    }
}
