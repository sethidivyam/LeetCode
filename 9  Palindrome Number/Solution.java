/*
9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
 */

 class Solution {
    public boolean isPalindrome(int x) {
        String n = Integer.toString(x);
        int len = n.length();
        for( int i = 0 ; i < len / 2 ; i++){
            if (n.charAt(i) != n.charAt(len -1 - i) ){
                return false;
            }
        }
        return true;
    }
}

// Follow-up solution without converting to string:
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int k = x;
        int n = 0;
        while(k != 0){
            n = n * 10 + k % 10 ;
            k = k / 10 ;
        }

        return n == x;
    }
}