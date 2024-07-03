import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[k + 1][n + 1];

            for (int i = 0; i < n; i++) {
                arr[0][i + 1] = i + 1;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }

            sb.append(arr[k][n]).append("\n");
        }


        System.out.println(sb);
    }
}
