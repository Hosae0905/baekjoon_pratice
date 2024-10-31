import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * 출처: https://melody-coding.tistory.com/482
 * 백준 2890번
 * 위성 사진은 R행 C열이다.
 * 모든 줄의 첫번째 글자는 S이고 출발선을 의미한다.
 * 마지막 글자는 F이고 결승선을 의미한다.
 * 대회에 참가한 팀은 총 9팀
 * 카약은 항상 열에 대해 연속하는 세 칸을 차지한다.
 * 카약은 번호로 표시되며 물은 .으로 나타나있다.
 * 결승선으로부터 떨어진 거리를 측정하여 순위를 매겨라(떨어진 거리가 같으면 같은 등수)
 * R, C는 10보다 크거나 같고, 50보다 작거나 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            int start = -1;
            int num = -1;
            int diff = 0;
            for (int j = 0; j < c; j++) {
                char x = str.charAt(j);
                if (Character.isDigit(x)) {
                    start = j;
                    num = x - '0';
                } else if (x == 'F') {
                    diff = c - 1 - start;
                }
            }

            if (num != -1) {
                list.add(new int[]{num, diff});
            }
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int result[] = new int[10];
        int diff = 0;
        int index = 0;
        for (int i = 0; i < 9; i++) {
            if (diff != list.get(i)[1]) {
                result[list.get(i)[0]] = ++index;
                diff = list.get(i)[1];
            } else {
                result[list.get(i)[0]] = index;
            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
