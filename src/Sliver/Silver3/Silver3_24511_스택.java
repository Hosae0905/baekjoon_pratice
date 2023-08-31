package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver3_24511_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer QueueOrStack = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> queuestack = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(st.nextToken());
            if (Integer.parseInt(QueueOrStack.nextToken()) == 0) {
                queuestack.add(M);
            }
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int M = Integer.parseInt(st.nextToken());
            queuestack.addFirst(M);
            sb.append(queuestack.pollLast()).append(" ");
        }
        System.out.println(sb);
    }
}
