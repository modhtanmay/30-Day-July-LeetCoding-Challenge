/*
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note: 0 ≤ x, y < 231.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 * The above arrows point to positions where the corresponding bits are
 * different.
 */

//SOLUTION

class Solution {

    public int hammingDistance(int x, int y) {
        String s1 = toBinary(x, 31);
        String s2 = toBinary(y, 31);
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count;
    }

    public static String toBinary(int x, int len) {
        if (len > 0) {
            return String.format("%" + len + "s", Integer.toBinaryString(x)).replaceAll(" ", "0");
        }
        return null;
    }

}