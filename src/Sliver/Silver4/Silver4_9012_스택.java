package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver4_9012_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(check(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

    public static String check(String test) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()){
                return "NO";
            } else {
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
