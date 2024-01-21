import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}