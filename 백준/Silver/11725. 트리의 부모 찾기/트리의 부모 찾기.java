import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    public static void dfs(int start) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[graph[start].get(i)]) {
                answer[graph[start].get(i)] = start;
                dfs(graph[start].get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = N - 1;
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

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

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
