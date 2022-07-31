package LeetCode.Neetcode150.BinarySearch;
/**
 * PROBLEM: https://leetcode.com/problems/koko-eating-bananas/
 * SOLUTION: https://www.youtube.com/watch?v=U2SozAs9RzA
 * BIG O: O(log(max(p))*p)
 */
public class KokoEatinBananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles)
            right = Math.max(right, pile);

        while (left < right) {
            // Get the middle index between left and right boundary indexes
            // hoursSpent stands for the total hour Koko spends
            int middle = (left + right) / 2;
            int hoursSpent = 0;

            // Iterate over the piles and calculate hoursSpent
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles)
                hoursSpent += Math.ceil((double) pile / middle);

            // Check if middle is a workable speed, and cut the search space by half
            if (hoursSpent <= h)
                right = middle;
            else
                left = middle + 1;
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed
        return right;
    }

    public static void main(String[] args) {
        int[] pile1 = { 3, 6, 7, 11 };
        int[] pile2 = { 30, 11, 23, 4, 20 };
        System.out.println(minEatingSpeed(pile1, 8));
        System.out.println(minEatingSpeed(pile2, 5));
        System.out.println(minEatingSpeed(pile2, 6));
    }
}
