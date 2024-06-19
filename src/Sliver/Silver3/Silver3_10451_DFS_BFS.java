package Sliver.Silver3;

import java.io.*;
import java.util.StringTokenizer;

public class Silver3_10451_DFS_BFS {
    static int N;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

    public static void dfs(int value) {
        visited[value] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[value][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            answer = 0;
            visited = new boolean[N + 1];
            graph = new boolean[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][num] = true;
                graph[num][i] = true;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    answer++;
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
