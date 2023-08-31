package Bronze.Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze5_9086_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] N = new String[T];

        for (int i = 0; i < T; i++) {
            N[i] = br.readLine();
        }

        for (int i = 0; i < N.length; i++) {
            char c = N[i].charAt(0);
            char c1 = N[i].charAt(N[i].length() - 1);
            sb.append(c).append(c1).append('\n');
        }
        System.out.println(sb);
    }
}
