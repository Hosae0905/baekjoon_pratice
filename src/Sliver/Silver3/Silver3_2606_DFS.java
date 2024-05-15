package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2606_DFS {

    static int computer = 0;
    static boolean[] visited;
    static boolean[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;
            arr[y][x] = true;
        }

        dfs(1);

        System.out.println(computer - 1);

        br.close();
    }

    public static void dfs(int start) {
        visited[start] = true;
        computer++;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && arr[start][i]) {
                dfs(i);
            }
        }
    }
}
