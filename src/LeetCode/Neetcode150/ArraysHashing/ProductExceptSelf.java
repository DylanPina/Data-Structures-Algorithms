package LeetCode.Neetcode150.ArraysHashing;
import java.util.Arrays;
/**
 * PROBLEM: https://leetcode.com/problems/product-of-array-except-self/
 * SOLUTION: https://www.youtube.com/watch?v=bNvIQI2wAjk
 * BIG O: O(n)
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] res = productExceptSelf(nums);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
