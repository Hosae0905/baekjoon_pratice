package Gold.Gold5;

import java.io.*;

/**
 * 참고: https://st-lab.tistory.com/95
 */

public class Gold5_2447_재귀 {

    static char[][] starArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        starArr = new char[N][N];       // N x N 패턴으로 2차원 배열 생성

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(starArr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean blank) {

        // 공백칸일 때
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    starArr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 블럭이 쪼개지지 않을 경우
        if (N == 1) {
            starArr[x][y] = '*';
            return;
        }

        int size = N / 3;   // 별이 차지하는 칸
        int count = 0;      // 몇 개의 별이 들어갔는지
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {       // 5번째 칸에는 별이 아닌 공백이 들어가야 된다.
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
