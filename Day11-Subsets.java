/*
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2],
 * [] ]
 */

// SOLUTION 1

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();
        toFindAllSubsets(nums, results, subset, 0);                

        return results;
    }

    private void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            toFindAllSubsets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);            
        }        
    }
}

// SOLUTION 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {
                    {
                        add(num);
                    }
                });
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}