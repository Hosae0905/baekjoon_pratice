package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver3_1966_자료구조 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            if (N == 1 && M == 0) {
                sb.append(1).append("\n");
                continue;
            }

            for (int i = 0; i < N; i++) {
                list.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!list.isEmpty()) {
                int[] front = list.poll();
                boolean max = true;

                for (int i = 0; i < list.size(); i++) {
                    if (front[1] < list.get(i)[1]) {
                        list.add(front);
                        for (int j = 0; j < i; j++) {
                            list.add(list.poll());
                        }

                        max = false;
                        break;
                    }
                }

                if (max == false) {
                    continue;
                }

                count++;
                if (front[0] == M) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
