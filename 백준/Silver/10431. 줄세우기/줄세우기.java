import java.io.*;
import java.util.*;
/**
 * 백준 10431번
 * 새로 반에 배정받은 아이들에게 키 순서대로 번호를 부여한다.
 * 키가 가장 작은 아이가 1번 ~
 * 반 아이들은 항상 20명이고 같은 키를 가진 학생은 한 명도 없다.
 * 아무나 한 명을 뽑아 줄의 맨 앞에 세운다.
 * 그 다음부터는 학생이 한 명씩 줄의 맨 뒤에 선다.
 * 자기 앞에 자기보다 키가 큰 학생이 없다면 그냥 그 자리에 서고 차례가 끝난다.
 * 자기 앞에 자기보다 키가 큰 학생이 한 명 이상 있다면 그중 가장 앞에 있는 학생의 바로 앞에 선다.
 * 이때, 키가 큰 학생 뒤에 서있는 모든 학생들은 공간을 만들기 위해 한 발씩 뒤로 물러서게 된다.
 * 이 과정을 반복해 오름차순으로 줄을 선다.
 * 아이들의 키가 주어지고, 어떤 순서로 아이들이 줄서기를 할 지 주어지면 위의 방법을 마지막 학생까지 시행하여 줄서기가 끝났을때
 * 학생들이 총 몇 번 뒤로 물러서게 될까?
 *
 * 테스트 케이스 P: 1 <= P <= 1,000
 * 각 테스트 케이스에는 케이스 번호 T와 20개의 양의 정수가 주어진다.
 *
 * 현재 몇명까지 줄을 세웠는지 알 수 있는 변수가 필요하다.
 * 선택 정렬과 비슷하게 풀 수 있다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 총 학급 수
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스마다 입력 값을 받아서 뒤로 물러난 걸음 수를 구한다.
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());       // 첫 번째 값인 테스트 케이스 번호를 저장한다.
            sb.append(index).append(" ");

            int count = 0;              // 몇 번 뒤로 물러가는지 저장하는 변수
            int[] num = new int[20];    // 반에 있는 학생 수(20명 고정)

            // 학생의 키를 배열에 저장한다.
            for (int j = 0; j < 20; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            // 반에 있는 학생들의 키를 비교한다.
            for (int j = 0; j < 20; j++) {
                // 현재까지 줄서있는 학생(k)과 현재 줄에 들어갈 학생(j)의 키를 한명씩 비교한다.
                for (int k = 0; k < j; k++) {
                    // 만약 현재 줄에 들어갈 학생(j)보다 키가 큰 사람(k)가 있다면 뒤로 물러가야하기 때문에 count를 증가시켜준다.
                    if (num[k] > num[j]) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }
}
