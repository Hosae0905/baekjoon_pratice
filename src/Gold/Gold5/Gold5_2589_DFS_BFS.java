package Gold.Gold5;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_2589_DFS_BFS {

    static final int MAX = 50 + 10;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        int max = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = node.x + dirX[i];
                int newY = node.y + dirY[i];

                if (map[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new Node(newX, newY, node.count + 1));
                    max = Math.max(max, node.count + 1);
                    visited[newX][newY] = true;
                }

            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[MAX][MAX];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (str.charAt(j - 1) == 'W') map[i][j] = 0;
                if (str.charAt(j - 1) == 'L') map[i][j] = 1;
            }
        }

        int max = -1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[MAX][MAX];
                    int result = bfs(i, j);
                    max = Math.max(max, result);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
}
