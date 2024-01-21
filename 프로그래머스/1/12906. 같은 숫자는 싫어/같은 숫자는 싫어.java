import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) stack.push(arr[0]);
            else if (stack.peek() == arr[i]) continue;
            else {
                stack.push(arr[i]);
            }
        }
        answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}