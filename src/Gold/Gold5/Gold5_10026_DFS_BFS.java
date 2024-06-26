package Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold5_10026_DFS_BFS {
    static final int MAX = 100 + 10;
    static int N, basic, rgb;
    static char[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        char temp = map[x][y];

        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];

            if (!visited[newX][newY] && map[newX][newY] == temp) {
                dfs(newX, newY);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            char[] array = str.toCharArray();
            for (int j = 1; j <= array.length; j++) {
                map[i][j] = array[j - 1];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    basic++;
                }
            }
        }

        sb.append(basic).append(" ");

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j);
                    rgb++;
                }
            }
        }

        sb.append(rgb);

        System.out.println(sb);
    }
}
