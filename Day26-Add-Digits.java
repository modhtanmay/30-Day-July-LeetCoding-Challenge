// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

// Example:

// Input: 38
// Output: 2 
// Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
//              Since 2 has only one digit, return it.
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?

//    Hide Hint #1  
// A naive implementation of the above process is trivial. Could you come up with other methods?
//    Hide Hint #2  
// What are all the possible results?
//    Hide Hint #3  
// How do they occur, periodically or randomly?
//    Hide Hint #4  
// You may find this Wikipedia article useful.

//SOLUTION

class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (sum > 9 || num > 0) {
            if (num == 0) {
                num = sum;
                sum = 0;
            }
            int r = num % 10;
            sum = sum + r;
            num = num / 10;
        }

        return sum;
    }
}