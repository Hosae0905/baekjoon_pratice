package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_6603_수학 {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr;


        while (true) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            visited = new boolean[K];
            arr = new int[K];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0, arr, visited);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void back(int start, int depth, int[] arr, boolean[] visited) {
        if (depth == 6) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(i + 1, depth + 1, arr, visited);
                visited[i] = false;
            }
        }
    }
}
