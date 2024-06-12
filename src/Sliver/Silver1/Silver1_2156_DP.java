package Sliver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1_2156_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cups = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cups[1];
        if (N > 1) {
            dp[2] = cups[1] + cups[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + cups[i], dp[i - 3] + cups[i - 1] + cups[i]));
        }

        System.out.println(dp[N]);
    }
}
