package Bronze.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze3_2441_별찍기 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void star(int n) {
        if (n <= 0) {
            return;
        }
        sb.append(" ".repeat(Math.max(0, count)));
        sb.append("*".repeat(n));
        sb.append("\n");

        count++;
        star(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        star(N);

        System.out.println(sb);
    }
}
