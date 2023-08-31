package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver4_28279_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String test = st.nextToken();

            if (test.equals("1")) deque.addFirst(Integer.parseInt(st.nextToken()));
            else if (test.equals("2")) deque.addLast(Integer.parseInt(st.nextToken()));
            else if (test.equals("3")) {
                if (!deque.isEmpty()) sb.append(deque.pollFirst()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("4")) {
                if (!deque.isEmpty()) sb.append(deque.pollLast()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("5")) sb.append(deque.size()).append('\n');
            else if (test.equals("6")) {
                if (deque.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (test.equals("7")) {
                if (!deque.isEmpty()) sb.append(deque.peekFirst()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("8")) {
                if (!deque.isEmpty()) sb.append(deque.peekLast()).append('\n');
                else sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
