import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int j = 0; j < 4; j++) {
                int newX = nowX + dirX[j];
                int newY = nowY + dirY[j];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if (visited[newX][newY] || map[newX][newY] == 0) continue;

                queue.add(new int[]{newX, newY});
                map[newX][newY] = map[nowX][nowY] + 1;
                visited[newX][newY] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        bw.write(String.valueOf(map[N - 1][M - 1]));
        bw.close();
        br.close();
    }
}
