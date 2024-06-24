package Sliver.Silver1;

import java.io.*;
import java.util.*;

public class Silver1_2667_DFS_BFS {

    static final int MAX = 25 + 10;
    static int N, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 4; j++) {
                int newY = y + dirY[j];
                int newX = x + dirX[j];

                if (map[newY][newX] == 1 && !visited[newY][newX]) {
                    count++;
                    dfs(newY, newX);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];
        count = 1;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (Integer value : list) {
            bw.write(value + "\n");
        }
        bw.close();
        br.close();
    }
}
