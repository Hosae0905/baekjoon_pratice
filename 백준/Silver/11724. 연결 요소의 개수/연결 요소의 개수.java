import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && graph[start][i]) {
                dfs(i);
            }
        }
    }
}
