import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {1, 0};
    static int[] dirX = {0, 1};
    final static int MAX = 3 + 110;     // 최대 게임 구역의 크기는 3, 칸에는 최대 100까지 들어올 수 있음, 여분으로 10을 추가 그래서 3 + 110

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        if (y == N && x == N) {
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newY = y + dirY[i] * map[y][x];
            int newX = x + dirX[i] * map[y][x];

            if (!visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 1);

        if (visited[N][N]) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }

        bw.close();
        br.close();
    }
}
