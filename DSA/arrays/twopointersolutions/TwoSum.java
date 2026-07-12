package arrays.twopointersolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * --------------------------------------------------------
     * BRUTE FORCE APPROACH
     * --------------------------------------------------------
     * <p>
     * IDEA:
     * <p>
     * Check every possible pair.
     * <p>
     * Think of it as introducing every person to every other person.
     * <p>
     * Person 1 meets Person 2
     * Person 1 meets Person 3
     * Person 1 meets Person 4
     * <p>
     * Then
     * <p>
     * Person 2 meets Person 3
     * Person 2 meets Person 4
     * <p>
     * Then
     * <p>
     * Person 3 meets Person 4
     * <p>
     * If any pair adds up to target,
     * return their indices.
     * <p>
     * Time Complexity:
     * O(n²)
     * <p>
     * Space Complexity:
     * O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {

        // Traverse each element
        for (int i = 0; i < nums.length; i++) {

            // Compare with every element after it
            for (int j = i + 1; j < nums.length; j++) {

                // Found the answer
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * --------------------------------------------------------
     * TWO POINTER APPROACH
     * --------------------------------------------------------
     *
     * IMPORTANT:
     *
     * This approach ONLY works on sorted arrays.
     *
     * If the given array is unsorted,
     * we must sort it first.
     *
     * NOTE:
     *
     * Sorting changes the original indices.
     *
     * Therefore this approach cannot directly solve
     * the original Leetcode Two Sum problem.
     *
     * It only helps us find the values.
     *
     * Time Complexity:
     * O(n log n)
     *
     * Space Complexity:
     * Depends on sorting implementation.
     */


    /**
     * --------------------------------------------------------
     * HASHMAP APPROACH
     * --------------------------------------------------------
     * <p>
     * IDEA:
     * <p>
     * Instead of checking every previous number,
     * remember the numbers we've already seen.
     * <p>
     * Example:
     * <p>
     * Target = 9
     * <p>
     * Current number = 7
     * <p>
     * We ask:
     * <p>
     * "What number do I need?"
     * <p>
     * 9 - 7 = 2
     * <p>
     * If 2 already exists inside the HashMap,
     * we've found the answer.
     * <p>
     * Time Complexity:
     * O(n)
     * <p>
     * Space Complexity:
     * O(n)
     */
    public static int[] twoSumHashMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // If complement already exists,
            // return both indices.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index.
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }


    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSumBruteForce(arr, target)));
        System.out.println(Arrays.toString(twoSumHashMap(arr, target)));

    }
}
