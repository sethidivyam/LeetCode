/*
78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i = 0 ; i < nums.length ; i++){
            int size = list.size();
            for(int j = 0 ; j < size ; j++){
                List<Integer> newSubset = new ArrayList<>(list.get(j));
                newSubset.add(nums[i]);
                list.add(newSubset);
            }
        }
        return list;
    }
}