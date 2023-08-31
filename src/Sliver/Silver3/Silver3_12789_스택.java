package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver3_12789_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> standbyLine = new Stack<>();
        Queue<Integer> currentLine = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            currentLine.add(Integer.parseInt(st.nextToken()));
        }

        int start = 1;

        while (!currentLine.isEmpty()) {
            if (currentLine.peek() == start) {
                currentLine.poll();
                start++;
            } else if (!standbyLine.isEmpty() && standbyLine.peek() == start) {
                standbyLine.pop();
                start++;
            } else {
                standbyLine.push(currentLine.poll());
            }
        }

        while (!standbyLine.isEmpty()) {
            if (standbyLine.peek() == start) {
                standbyLine.pop();
                start++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
