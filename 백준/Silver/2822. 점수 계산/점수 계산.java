import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/**
 * 8개의 문제에서 가장 높은 점수 5개를 합한 결과를 출력한다.  --> 내림차순
 * 점수는 0보다 크거나 같고 150보다 작거나 같다.
 * 점수는 중복되지 않는다.
 *
 * 몇 번 문제를 합했는지 알아야 하기 때문에 문제 번호도 저장할 필요가 있다.
 * 문제 번호는 오름차순으로 정렬해야 한다.
 * 문제는 총 8개로 고정되어 있기 때문에 시간복잡도를 생각하지 않고 풀어도 무방하다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];        // 문제 번호와 점수를 저장할 2차원 배열
        int answer = 0;                     // 총합을 출력할 변수
        StringBuilder sb = new StringBuilder();     // 문제 번호를 출력할 변수
        int[] num = new int[5];             // 문제 번호를 저장할 1차원 배열

        for(int i = 0; i < arr.length; i++) {
            arr[i][0] = i + 1;          // 문제 번호를 저장
            arr[i][1] = Integer.parseInt(br.readLine());        // 점수를 저장
        }

        // 점수를 기준으로 내림차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        // 가장 높은 점수 5개만 answer에 더하고, 각 문제 번호를 num 배열에 저장
        for(int i = 0; i < 5; i++) {
            answer += arr[i][1];
            num[i] = arr[i][0];
        }

        // 문제 번호를 기준으로 오름차순 정렬
        Arrays.sort(num);
        
        // 문제 번호를 sb에 저장
        for(int i = 0; i < num.length; i++) {
            sb.append(num[i]).append(" ");
        }

        System.out.println(answer);
        System.out.println(sb.toString());
    }
}
