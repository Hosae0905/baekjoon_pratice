package Bronze.Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze3_2566_2차원배열 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = 9;
        int M = 9;
        int[][] matrix = new int[N][M];
        int result = 0;
        int position = 0;
        int position1 = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] > result) {
                    result = matrix[i][j];
                    position = i + 1;
                    position1 = j + 1;
                } else if (result == 0) {
                    position = 1;
                    position1 = 1;
                }
            }
        }

        // 출력
        System.out.println(result);
        System.out.println(position + " " + position1);
    }
}
