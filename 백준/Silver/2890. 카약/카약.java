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
        int r = Integer.parseInt(st.nextToken());       // 행
        int c = Integer.parseInt(st.nextToken());       // 열

        ArrayList<int[]> list = new ArrayList<>();      // 카약 번호와 점수를 담을 리스트

        // 한 라인씩 돌면서 카약 번호와 점수를 계산한다.
        for (int i = 0; i < r; i++) {
            String str = br.readLine();     // 라인 하나
            int start = -1;      // 출발지점 초기화
            int num = -1;        // 카약 번호
            int score = 0;       // 점수

            // 하나의 라인에서 글자 하나씩 뽑아 점수를 계산한다.
            for (int j = 0; j < c; j++) {
                char x = str.charAt(j);     // 라인에서 글자 하나 뽑기

                /*
                * 만약 뽑은 글자가 숫자라면 시작점과 카약 번호를 구한다.
                * 그렇지 않고 만약 뽑은 글자가 'F'라면 종료지점이기 때문에 최종 점수를 구한다.
                * */
                if (Character.isDigit(x)) {
                    start = j;
                    num = x - '0';
                } else if (x == 'F') {
                    score = c - 1 - start;
                }
            }

            // 만약 카약 번호가 -1이 아니라면 리스트에 해당 카약 번호와 점수를 저장한다.
            if (num != -1) {
                list.add(new int[]{num, score});
            }
        }

        // 점수를 기준으로 오름차순 정렬을 진행한다.
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int result[] = new int[10];     // 결과를 담을 배열
        int diff = 0;                   // 앞 팀의 결승선과 떨어진 거리
        int index = 0;                  // 등수
        for (int i = 0; i < 9; i++) {
            /*
            * 만약 앞 팀의 결승선과 떨어진 거리가 다르다면 등수가 달라진다.
            * 정답 배열에 카약 번호의 위치에서 등수를 저장한다.
            * 그렇지 않다면(앞 팀의 결승선과 떨어진 거리가 같다면) 같은 등수이기 때문에 같은 등수로 저장한다.
            * */
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
