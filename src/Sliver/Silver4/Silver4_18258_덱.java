package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver4_18258_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> queue = new LinkedList();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String test = st.nextToken();
            if (test.equals("push")) queue.add(Integer.parseInt(st.nextToken()));
            else if (test.equals("pop")) {
                if (!queue.isEmpty()) sb.append(queue.poll()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("size")) sb.append(queue.size()).append('\n');
            else if (test.equals("empty")) {
                if (queue.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else if (test.equals("front")) {
                if (!queue.isEmpty()) sb.append(queue.peek()).append('\n');
                else sb.append(-1).append('\n');
            } else if (test.equals("back")) {
                if (!queue.isEmpty()) sb.append(queue.peekLast()).append('\n');
                else sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);
    }
}
