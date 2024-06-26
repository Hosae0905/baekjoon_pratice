package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver2_1874_자료구조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > start) {
                for (int i = start + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
