import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, V;
    static boolean[] visited;
    static boolean[][] graph;
    static ArrayList<Integer> queue;


    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false && graph[start][i] == true) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[N + 1];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int index = queue.remove(0);
            System.out.print(index + " ");
            for (int i = 1; i <= N; i++) {
                if (visited[i] == false && graph[index][i] == true) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(V);
        System.out.println();
        bfs();

    }
}
