import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push('(');
            } else if (charArray[i] == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}