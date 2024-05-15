import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static boolean[][] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        System.out.println(answer);
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
