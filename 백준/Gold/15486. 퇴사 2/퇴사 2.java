import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] table = new int[2][N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            table[0][i] = Integer.parseInt(st.nextToken());
            table[1][i] = Integer.parseInt(st.nextToken());
        }


        int max = -1;
        for (int i = 1; i <= N + 1; i++) {
            if (max < dp[i]) max = dp[i];
            int next = i + table[0][i];
            if (next < N + 2) dp[next] = Math.max(dp[next], max + table[1][i]);
        }

        System.out.println(dp[N + 1]);
    }
}
