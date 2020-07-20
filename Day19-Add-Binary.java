/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * Input: a = "11", b = "1" Output: "100" Example 2:
 * 
 * Input: a = "1010", b = "1011" Output: "10101"
 */

//SOLUTION

class Solution {
    public String addBinary(String a, String b) {
        // long n1=Integer.parseInt(a),n2=Integer.parseInt(b);
        // int p=0,s1=0,s2=0;

        // while(n1!=0) {
        // int r = (int)n1%10;
        // s1 = s1 + (r * (int)Math.pow(2,p++));
        // //System.out.println(s1);
        // n1 = n1/10;
        // }
        // p = 0;
        // while(n2!=0) {
        // int r = (int)n2%10;
        // s2 = s2 + (r * (int)Math.pow(2,p++));
        // //System.out.println(s2);
        // n2 = n2/10;
        // }
        // System.out.println(s1+s2);
        // return Integer.toBinaryString(s1+s2);

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum = sum + a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum = sum + b.charAt(j--) - '0';
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        if (carry > 0)
            sb.insert(0, 1);

        return sb.toString();
    }
}