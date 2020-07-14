/*
 * Given a non-empty array of digits representing a non-negative integer,
 * increment one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contains a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer
 * 123. Example 2:
 * 
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the
 * integer 4321.
 */

//SOLUTION

public class Solution {
    public int[] plusOne(int[] digits) {
        return plus(digits, digits.length - 1);
    }

    private int[] plus(int[] digits, int index) {
        if (digits[index] < 9) {
            digits[index]++;
            return digits;
        } else {
            if (index != 0) {
                digits[index] = 0;
                return plus(digits, index - 1);
            } else {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                return res;
            }
        }
    }
}