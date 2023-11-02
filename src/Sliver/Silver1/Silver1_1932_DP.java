package Sliver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_1932_DP {

    static int[][] arr;
    static Integer[][] dpArr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dpArr = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dpArr[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(find(0, 0));
    }

    public static int find(int depth, int index) {
        if (depth == N - 1) {
            return dpArr[depth][index];
        }

        if (dpArr[depth][index] == null) {
            dpArr[depth][index] = Math.max(find(depth + 1, index), find(depth + 1, index + 1)) + arr[depth][index];
        }
        return dpArr[depth][index];
    }
}
