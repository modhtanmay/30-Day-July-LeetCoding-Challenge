/*
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * 
 * Example:
 * 
 * Input: n = 10 Output: 12 Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the
 * sequence of the first 10 ugly numbers. Note:
 * 
 * 1 is typically treated as an ugly number. n does not exceed 1690. Hide Hint
 * #1 The naive approach is to call isUgly for every number until you reach the
 * nth one. Most numbers are not ugly. Try to focus your effort on generating
 * only the ugly ones. Hide Hint #2 An ugly number must be multiplied by either
 * 2, 3, or 5 from a smaller ugly number. Hide Hint #3 The key is how to
 * maintain the order of the ugly numbers. Try a similar approach of merging
 * from three sorted lists: L1, L2, and L3. Hide Hint #4 Assume you have Uk, the
 * kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */

//SOLUTION - 1

 class Solution {
     public int nthUglyNumber(int n) {
         int num = 0;
         while(n > 0) {
             ++num;
             if(isUgly(n))
                 n--;
         }
         return num;
     }

     public boolean isUgly(int n) {
         for(int i=2;i<6 && n>0 ; i++)
             while(n % i == 0)
                 n = n / i;
         return n == 1;
     }
 }

// SOLUTION 2
 class Solution {
     public int nthUglyNumber(int n) {
         List<Integer> ugly = new ArrayList<Integer>();
         long two, three, five, m = Integer.MAX_VALUE;
         for (two = 1; two <= m; two *= 2)
             for (three = two; three <= m; three *= 3)
                 for (five = three; five <= m; five *= 5)
                     ugly.add((int) five);
         Collections.sort(ugly);
         return ugly.get(n - 1);
     }
 }