import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i) == ')') {
                stack.pop();
            }

            if (i > 0) {
                if (str.charAt(i - 1) == '(' && str.charAt(i) == ')') {
                    sum += stack.size();
                } else if (str.charAt(i - 1) == ')' && str.charAt(i) == ')') {                  
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}