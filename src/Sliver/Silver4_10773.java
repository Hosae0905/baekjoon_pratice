package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver4_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) stack.pop();
            else stack.push(temp);
        }

        for (int num : stack) {
            result += num;
        }

        System.out.println(result);
    }
}
