package Sliver.Silver2;

import java.io.*;
import java.util.*;

public class Silver2_24479_DFS {

    static int N, M, R;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] answer;
    static int order;


    public static void dfs(int start) {
        visited[start] = true;
        answer[start] = order;
        order++;

        for (int i = 0; i < graph[start].size(); i++) {
            int value = graph[start].get(i);
            if (visited[value] == false) {
                dfs(value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        answer = new int[N + 1];
        order = 1;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(R);

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
