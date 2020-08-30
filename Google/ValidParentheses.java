/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        HashMap<Character, Character> bracketSet = new HashMap<>();
        bracketSet.put('}','{');
        bracketSet.put(']','[');
        bracketSet.put(')','(');        
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(!bracketSet.containsKey(c)){
                queue.addFirst(c);
            } else {
                if(queue.peek() != bracketSet.get(c)) return false;
                queue.removeFirst();
            }
        }
        if(queue.size() == 0) return true;
        return false;
    }
}
