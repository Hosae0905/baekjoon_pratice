package Sliver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_2630_재귀 {
    static int[][] graph;
    static int white, blue;

    public static void search(int y, int x, int size) {
        if (check(y, x, size)) {
            if (graph[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        search(y, x, newSize);
        search(y, x + newSize, newSize);
        search(y + newSize, x, newSize);
        search(y + newSize, x + newSize, newSize);
    }

    public static boolean check(int y, int x, int size) {
        int color = graph[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (graph[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
