package Gold.Gold5;

import java.io.*;

/**
 * 참고: https://st-lab.tistory.com/96
 */

public class Gold5_11729_재귀 {

/*    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] hanoi = new int[N];
        count = new int[N];

        for (int i = 0; i < N; i++) {
            count[i] = N--;
        }

        move(hanoi);
    }

    public static void move(int[] hanoi) {


    }*/

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 원판의 개수

        sb.append((int) (Math.pow(2, N) - 1)).append('\n');     // 3번째 장대로 옮기는데 필요한 이동 횟수

        hanoi(N, 1, 2, 3);      // 원판과 장대

        System.out.println(sb);
    }

    public static void hanoi(int N, int start, int mid, int to) {   // 원판, 출발지, 중간지, 목적지
        if (N == 1) {       // 원판의 개수가 1일때
            sb.append(start + " " + to + "\n");
            return;
        }

        // 첫 번째 장대 -> 세 번째 장대로 옮길 때
        // N - 1개를 첫 번째 장대에서 두 번째 장대로 이동
        hanoi(N - 1, start, to, mid);

        // 가장 작은 1개를 첫 번째 장대에서 세 번째 장대로 이동
        sb.append(start + " " + to + "\n");

        // 두 번째 장대에 있는 N - 1개의 원판을 세 번째 장대로 이동
        hanoi(N - 1, mid, start, to);
    }
}
