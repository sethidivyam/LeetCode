/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

class Solution {
    private static final String[] keys = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> multiplyStringArrays(List<String[]> arrays) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (String[] arr : arrays) {
            List<String> temp = new ArrayList<>();
            for (String prefix : result) {
                for (String s : arr) {
                    temp.add(prefix + s);
                }
            }
            result = temp;
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();

        List<String[]> arrays = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            int d = digits.charAt(i) - '0';
            String letters = keys[d];
            arrays.add(letters.split("")); 
        }

        return multiplyStringArrays(arrays);
    }
}
