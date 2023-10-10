package Bronze.Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_10798_2차원배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 15;
        int M = 5;

        /*String[] strArr = new String[N];

        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            char[] chArr = strArr[i].toCharArray();
            sb.append(chArr[i]);
        }*/

        char[][] chArr = new char[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                chArr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chArr[j][i] != '\0') {
                    sb.append(chArr[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}
