package Sliver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_11651_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] M = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M[i][0] = Integer.parseInt(st.nextToken());
            M[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(M, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
        });


        for (int i = 0; i < N; i++) {
            sb.append(M[i][0]).append(" ").append(M[i][1]).append('\n');
        }

        System.out.println(sb);
    }
}
