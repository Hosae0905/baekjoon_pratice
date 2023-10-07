package Bronze.Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze5_2738_2차원배열 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        // 초기화
        for (int i = 0; i < N; i++) {       // ??? 왜 length랑 N이랑 다르게 작동하지? 2차원 배열의 length는 다른건가??
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(A.length);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행렬 A, B를 만들어서 각 요소 값을 더해 새로운 행렬을 만든다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append((A[i][j] + B[i][j]) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
