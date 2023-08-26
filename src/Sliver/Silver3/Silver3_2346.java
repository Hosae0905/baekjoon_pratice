package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Silver3_2346 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();

        int[] K = new int[N];
        for (int i = 0; i < N; i++) {
            K[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("1 ");
        int T = K[0];

        for (int i = 1; i < N; i++) {
            deque.add(new int[] {(i+1), K[i]});
        }

        while (!deque.isEmpty()) {
            if (T > 0) {
                for (int i = 1; i < T; i++) {
                    deque.add(deque.poll());
                }
                int[] next = deque.poll();
                T = next[1];
                sb.append(next[0] + " ");
            } else {
                for (int i = 1; i <- T; i++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] next = deque.pollLast();
                T = next[1];
                sb.append(next[0] + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
