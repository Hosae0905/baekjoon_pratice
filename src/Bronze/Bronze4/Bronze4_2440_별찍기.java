package Bronze.Bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze4_2440_별찍기 {
    static StringBuilder sb = new StringBuilder();
    public static void star(int n) {

        if (n <= 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            sb.append("*");
        }

        sb.append("\n");
        star(n - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        star(N);

        System.out.println(sb);
    }
}
