// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// Example:

// Input:  [1,2,1,3,2,5]
// Output: [3,5]
// Note:

// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity



// SOLUTION 1 : USING HASHMAP

class Solution {
    public int[] singleNumber(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : nums) {
            if (!hm.containsKey(i))
                hm.put(i, 1);
            else
                hm.put(i, hm.get(i) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1)
                list.add(entry.getKey());
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}

// SOLUTION 2 : USING XOR

class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;
        for (int n : nums)
            xor ^= n;
        int mask = (xor & (xor - 1)) ^ xor;

        int num1 = 0;
        for (int n : nums)
            if ((mask & n) == 0)
                num1 ^= n;

        return new int[] { num1, xor ^ num1 };

    }
}
