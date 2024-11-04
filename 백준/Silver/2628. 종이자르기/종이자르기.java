import java.io.*;
import java.util.*;
/**
 * 출처: https://yoon990.tistory.com/45
 * 종이 자르기
 * 가로 방향과 세로 방향으로 1cm마다 점선이 그어져 있다.
 * 종이의 가로 세로 길이 잘라야할 점선들이 주어졌을 때 가장 큰 종이 조각의 넓이가 몇인지 구하는 프로그램을 구하시오.
 *
 * 가로와 세로의 길이는 최대 100cm
 * 칼로 잘라야 하는 점선의 개수
 * 가로로 자르는 점선은 0과 점선 번호
 * 세로로 자르는 점선은 1과 점선 번호
 *
 * 넓이의 단위는 출력하지 않음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());       // 가로 길이
        int y = Integer.parseInt(st.nextToken());       // 세로 길이
        int n = Integer.parseInt(br.readLine());        // 점선의 개수

        int[] cutX = new int[x + 1];        // 가로 길이 배열
        int[] cutY = new int[y + 1];        // 세로 길이 배열

        // 잘라야하는 횟수 만큼 반복하며 가로 혹은 세로 방향과 자르는 위치를 입력 받는다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            /*
            * 만약 방향이 0이라면(가로 방향이라면)
            *   가로 길이를 저장한 cutN 배열에서 num(자르는 위치)위치에 값을 1로 바꿔준다.
            * 그렇지 않다면(세로 방향이라면)
            *   세로 길이를 저장한 cutM 배열에서 num(자르는 위치)위치에 값을 1로 바꿔준다.
            * */
            if (dir == 0) {
                cutY[num] = 1;
            } else {
                cutX[num] = 1;
            }
        }



        int temp = 0;       // 나눠진 길이를 저장할 변수
        int maxX = 0;       // 최대 가로 길이를 저장할 변수

        // 가로 길이 만큼 반복한다.
        for (int i = 1; i <= x; i++) {
            temp++;     // 나눠진 부분의 가로 길이를 구하기 위해 temp를 증가시킨다.

            /*
            * 만약 cutM[i]가 1이라면(자른 위치) 혹은 i가 x(가로 최대 길이)와 같다면
            *   maxX 변수에 기존의 maxX과 나눠진 부분의 가로 길이를 구한 temp를 비교화여 최댓값을 저장한다.
            *   저장한 뒤 temp 변수에 다시 0을 저장한다.
            * */
            if (cutX[i] == 1 || i == x) {
                maxX = Math.max(maxX, temp);
                temp = 0;
            }
        }

        temp = 0;           // 나눠진 길이를 저장할 변수
        int maxY = 0;       // 최대 세로 길이를 저장할 변수

        // 세로 길이 만큼 반복한다.
        for (int i = 1; i <= y; i++) {
            temp++;     // 나눠진 부분의 세로 길이를 구하기 위해 temp를 증가시킨다.

            /*
             * 만약 cutN[i]가 1이라면(자른 위치) 혹은 i가 y(세로 최대 길이)와 같다면
             *   maxY 변수에 기존의 maxY와 나눠진 부분의 세로 길이를 구한 temp를 비교화여 최댓값을 저장한다.
             *   저장한 뒤 temp 변수에 다시 0을 저장한다.
             * */
            if (cutY[i] == 1 || i == y) {
                maxY = Math.max(maxY, temp);
                temp = 0;
            }
        }

        // 최대 가로 길이와 세로 길이를 곱한 뒤 출력한다.
        System.out.println(maxX * maxY);

    }
}
