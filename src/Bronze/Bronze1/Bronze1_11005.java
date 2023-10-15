package Bronze.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze1_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());   // 36

        while (N != 0) {
            if (N % B >= 10) {
                sb.append((char) ((N % B) + 55));
            } else {
                sb.append(N % B);
            }
            N /= B;
        }


        System.out.println(sb.toString());
        System.out.println(sb.reverse().toString());        // reverse 필요
    }
}
