package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver4_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String test = st.nextToken();
            if (test.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
            else if (test.equals("pop")) {
                if (!stack.isEmpty()) sb.append(stack.pop()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("size")) sb.append(stack.size()).append('\n');
            else if (test.equals("empty")) {
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (test.equals("top")) {
                if (!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                else sb.append(-1).append('\n');
            }
        }

        System.out.println(sb);
    }
}
