/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        double median = 0;
        int a = 0, b = 0, i = 0;
        int[] nums = new int[ x + y ];
        while(a < x && b < y ){
            if (nums1[a] <= nums2[b]){
                nums[i++] = nums1[a++];
            } else{
                nums[i++] = nums2[b++];
            }
        }
        while (a < x) nums[i++] = nums1[a++];
        while (b < y) nums[i++] = nums2[b++];

        
        if((a+b) % 2 == 1){
            median = nums[(a+b)/2];
        } else {
            median = ( nums[(a+b)/2 -1 ] + nums[(a+b)/2] )/2.0 ;
        }

        return median;
    }
}