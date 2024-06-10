package Sliver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_2579_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] stair = new long[N + 1];
        long[] result = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        result[1] = stair[1];

        if (N >= 2) {
            result[2] = stair[1] + stair[2];
        }

        for (int i = 3; i <= N; i++) {
            result[i] = Math.max(result[i - 2], result[i - 3] + stair[i - 1]) + stair[i];
        }

        System.out.println(result[N]);
    }
}
