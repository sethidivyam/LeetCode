/*
67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder output = new StringBuilder();
        int i = a.length() -1 ;
        int j = b.length() -1 ;
        int carry = 0 ;
        while( i >= 0  ||  j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0 ){
                sum += Integer.parseInt(String.valueOf(a.charAt(i)) );
                i--;
            }
            if(j >= 0 ){
                sum += Integer.parseInt(String.valueOf(b.charAt(j)) );
                j--;
            }
            output.append(sum % 2);
            carry = sum/2;
        }
        return output.reverse().toString(); 
    }
}