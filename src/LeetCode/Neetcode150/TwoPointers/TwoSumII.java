package LeetCode.Neetcode150.TwoPointers;
/**
 * PROBLEM: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * SOLUTION: https://www.youtube.com/watch?v=cQ1Oz4ckceM
 * BIG O: O(n)
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0, rightPointer = numbers.length - 1;
        int num_a, num_b;

        while(leftPointer < rightPointer) {
            num_a = numbers[leftPointer];
            num_b = numbers[rightPointer];

            if (num_a + num_b == target) break;

             if (num_a + num_b < target) {
                leftPointer++;
                continue;
            }

            rightPointer--;
        }

        return new int[] { leftPointer + 1, rightPointer + 1 };
    }

    public static void main(String[] args) {
        int[] input1 = { 2, 7, 11, 15 };
        int[] res1 = twoSum(input1, 9);
        for (int num : res1)
            System.out.print(num + " ");

        System.out.println();
        int[] input2 = { 2, 3, 4 };
        int[] res2 = twoSum(input2, 6);
        for (int num : res2)
            System.out.print(num + " ");

        System.out.println();
        int[] input3 = { -1, 0 };
        int[] res3 = twoSum(input3, -1);
        for (int num : res3)
            System.out.print(num + " ");
    }
}
