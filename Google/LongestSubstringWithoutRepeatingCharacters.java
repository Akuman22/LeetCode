/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int startPointer = 0;
        int length = 1;
        int i = 0;
        while(i < s.length()){
            while(s.substring(startPointer, i).contains(String.valueOf(s.charAt(i)))) startPointer++ ;
            i++;
            if(i - startPointer > length) length = i - startPointer;
        }
        return length;
    }
}
             
