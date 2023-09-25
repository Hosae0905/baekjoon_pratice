package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver4_10773_스택_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());            // 주어진 수
        int result = 0;

        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());     // 주어진 수 만큼 숫자 받기

            if (temp == 0) stack.pop();                     // 잘못된 수를 부를 경우 지우기
            else stack.push(temp);                          // 아닐 경우 추가하기
        }

        for (int num : stack) {     // 최종적으로 stack에 남아있는 값을 더하기
            result += num;
        }

        System.out.println(result);
    }
}
