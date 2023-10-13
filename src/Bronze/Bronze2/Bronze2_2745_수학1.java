package Bronze.Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_2745_수학1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();                  // ZZZZZ
        int B = Integer.parseInt(st.nextToken());   // 36
        int idx = 0;
        int num = 0;
        long result = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            char C = N.charAt(i);

            if ('0' <= C && C <= '9') {
                num = C - '0';
            } else {
                num = C - 55;
            }
            result += num * Math.pow(B, idx++);
        }
        System.out.println(result);
    }
}
