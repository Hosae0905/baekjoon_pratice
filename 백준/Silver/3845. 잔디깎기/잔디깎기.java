import java.io.*;
import java.util.*;

/**
 * 출처: https://steadycoding-turtleman.tistory.com/entry
 * 경기장의 잔디밭은 언제나 100미터 길이에 폭은 75미터이다.
 * 잔디깍거는 잔디의 가로와 세로에 평행하게 여러 개의 길을 만들어 길을 따라 이동하며 잔디를 깎는다.
 * 필드를 순서대로 하는 것이 아닌 랜덤으로 길을 정해 시작하는 것을 좋아한다.
 * 잔디가 완벽하게 깎였는지 확인하는 프로그램을 만들어라.
 * 완벽하게 깎였다는 것은 모든 부분의 잔디가 가로로도 세로로도 최소 한 번 이상 깎인 상태를 의미한다.
 *
 * 테스트 케이스는 총 3라인
 * 두 정수 nx, ny: 0 < nx, ny < 1,000
 * 잔디 깎는 기계의 폭 w: 0 < w <= 50
 * 가로에 평행하게 깎는 길들의 실수 좌표 xi: 0 <= xi <= 75(nx개 만큼 주어짐)
 * 세로에 평행하게 깎는 길들의 실수 좌표 yi: 0 <= yi <= 100(ny개 만큼 주어짐)
 * 테스트 케이스의 마지막에는 0 0 0.0
 * 실수 w, xi, yi는 10진법 소숫점 7째 자리까지 주어지며 잔디를 깎을 때 깎이는 범위에 가장자리도 포함
 *
 * 잔디를 완벽히 깎았다면 YES, 아니면 NO를 출력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nx = Integer.parseInt(st.nextToken());      // x좌표 개수
        int ny = Integer.parseInt(st.nextToken());      // y좌표 개수
        double w = Double.parseDouble(st.nextToken());  // 잔디깎이 폭
        StringBuilder sb = new StringBuilder();
        double now;     // 현재까지 잔디를 깎은 구간

        while(nx != 0 && ny != 0 && w != 0.0) {
            double[] x = new double[nx];        // 잔디를 가로로 깎는 좌표를 저장할 배열
            double[] y = new double[ny];        // 잔디를 세로로 깎는 좌표를 저장할 배열
            boolean isChecked = true;           // 완벽하게 깎았는지 확인할 변수

            st = new StringTokenizer(br.readLine());
            // 가로 좌표값을 배열에 저장
            for(int i = 0; i < nx; i++) {
                x[i] = Double.parseDouble(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            // 세로 좌표값을 배열에 저장
            for(int i = 0; i < ny; i++) {
                y[i] = Double.parseDouble(st.nextToken());
            }

            Arrays.sort(x);         // 잔디의 위치 중 0부터 깎기 위해 가로 좌표를 오름차순으로 정렬
            now = 0;                // 현재까지 깎은 구간을 0으로 초기화

            // 가로 좌표를 하나씩 꺼내서 완벽하게 깎을 수 있는지 확인
            for (int i = 0; i < nx; i++) {
                /*
                * 만약 가로 좌표의 값이 현재까지 잔디를 깎은 구간보다 더 작다면 잔디를 계속 깎는다.
                * 그렇지 않다면 중간에 정리되지 못하는 부분이 발생하는 것이므로 완벽하지 않다고 판단해 false 값을 저장하고 반복문을 종료한다.
                * */
                if (x[i] - (w / 2) <= now) {
                    now = x[i] + (w / 2);
                } else {
                    isChecked = false;
                    break;
                }
            }

            // 만약 완벽하게 깎지 못했거나 잔디의 폭인 75까지 깎지 못했다면 완벽하지 않기 때문에 다음 테스트 케이스로 넘어간다.
            if (!isChecked || now < 75) {
                sb.append("NO\n");      // 완벽하지 않기 때문에 NO 저장
                st = new StringTokenizer(br.readLine());
                nx = Integer.parseInt(st.nextToken());      // 새로운 nx 값을 저장
                ny = Integer.parseInt(st.nextToken());      // 새로운 ny 값을 저장
                w = Double.parseDouble(st.nextToken());     // 새로운 잔디깎기 폭을 저장
                continue;
            }

            Arrays.sort(y);         // 잔디의 위치 중 0부터 깎기 위해 세로 좌표를 오름차순으로 정렬
            now = 0;                // 현재까지 깎은 구간을 0으로 초기화

            // 세로 좌표를 하나씩 꺼내서 완벽하게 깎을 수 있는지 확인
            for (int i = 0; i < ny; i++) {
                /*
                 * 만약 세로 좌표의 값이 현재까지 잔디를 깎은 구간보다 더 작다면 잔디를 계속 깎는다.
                 * 그렇지 않다면 중간에 정리되지 못하는 부분이 발생하는 것이므로 완벽하지 않다고 판단해 false 값을 저장하고 반복문을 종료한다.
                 * */
                if (y[i] - (w / 2) <= now) {
                    now = y[i] + (w / 2);
                } else {
                    isChecked = false;
                    break;
                }
            }

            /*
            * 만약 완벽하게 깎지 못했거나 혹은 잔디의 길이인 100을 넘지 못했다면 NO을 저장한다.
            * 그렇지 않다면 완벽하게 깎은 것이라 판단하여 YES를 저장한다.
            * */
            if (!isChecked || now < 100) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }

            st = new StringTokenizer(br.readLine());
            nx = Integer.parseInt(st.nextToken());          // 새로운 nx 값을 저장
            ny = Integer.parseInt(st.nextToken());          // 새로운 ny 값을 저장
            w = Double.parseDouble(st.nextToken());         // 새로운 잔디깎기 폭을 저장
        }

        System.out.println(sb.toString());
    }
}
