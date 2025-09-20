/* 
5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public boolean Palindrome(String str){
        for(int i = 0 ; i < str.length() / 2 ; i++ ){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String max = "" ;
        String str = "";
        for(int i = 0 ; i < s.length() ; i++){
            str = s.charAt(i) + "" ;
            for(int j = i + 1 ; j < s.length() ; j++){
                str = str + s.charAt(j) ;
                if(max.length() < str.length() && Palindrome(str)){
                    max = str ;
                }
            }
            if(max.length() < str.length() && Palindrome(str)){
                max = str ;
            }
        }
        return max;
        
    }
}