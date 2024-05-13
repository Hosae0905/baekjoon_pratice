package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver3_1935_자료구조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String str = br.readLine();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }


        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                stack.push(arr[str.charAt(i) - 'A']);
            } else if (str.charAt(i) == '+') {
                Double x = stack.pop();
                Double y = stack.pop();
                stack.push(x + y);

            } else if (str.charAt(i) == '*') {
                Double x = stack.pop();
                Double y = stack.pop();
                stack.push(y * x);
            } else if (str.charAt(i) == '/') {
                Double x = stack.pop();
                Double y = stack.pop();
                stack.push(y / x);
            } else if (str.charAt(i) == '%') {
                Double x = stack.pop();
                Double y = stack.pop();
                stack.push(y % x);
            } else if (str.charAt(i) == '-') {
                Double x = stack.pop();
                Double y = stack.pop();
                stack.push(y - x);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
