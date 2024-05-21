package Gold.Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold3_2812_자료구조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int length = N - K;

        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && K > 0 && stack.peek() < str.charAt(i)) {
                    stack.pop();
                    K--;
                }
            }

            stack.push(str.charAt(i));
        }

        while (true) {
            if (stack.size() == length) break;
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse());
    }
}
