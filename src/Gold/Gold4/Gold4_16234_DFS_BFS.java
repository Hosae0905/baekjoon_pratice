package Gold.Gold4;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold4_16234_DFS_BFS {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;

    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};
    static ArrayList<Node> list;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int move() {
        int result = 0;
        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            changePopulation(sum);
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) {
                return result;
            } else {
                result++;
            }
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();
        queue.add(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = map[x][y];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = node.x + dirX[i];
                int newY = node.y + dirY[i];
                if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY]) {
                    int dif = Math.abs(map[node.x][node.y] - map[newX][newY]);
                    if (L <= dif && dif <= R) {
                        queue.add(new Node(newX, newY));
                        list.add(new Node(newX, newY));
                        sum += map[newX][newY];
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return sum;
    }

    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (Node node : list) {
            map[node.x][node.y] = avg;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(move()));
        bw.close();
        br.close();
    }
}
