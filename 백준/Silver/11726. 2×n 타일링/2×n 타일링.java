import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] tile = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tile[1] = 1;
        tile[2] = 2;

        for (int i = 3; i <= N; i++) {
            tile[i] = (tile[i - 1] + tile[i - 2]) % 10007;
        }

        System.out.println(tile[N]);
    }
}
