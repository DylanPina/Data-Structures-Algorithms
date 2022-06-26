package LeetCode.Neetcode150.ArraysHashing;
import java.util.*;
/**
 * PROBLEM: https://leetcode.com/problems/top-k-frequent-elements/
 * SOLUTION: https://www.youtube.com/watch?v=YPTqKIgVk-k
 * BIG O: O(n)
 */
public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (k == nums.length) return new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) ->
                e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<Integer> topNumbers = new ArrayList<>();
        while (!minHeap.isEmpty())
            topNumbers.add(minHeap.poll().getKey());

        return topNumbers;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(topKFrequent(nums, 2));
    }
}
