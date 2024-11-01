import java.io.*;
import java.util.*;
/**
 * 백준 9237번
 * 나무 묘목 n개
 * 묘목을 하나 심는데 걸리는 시간은 1일
 * 각 묘목이 다 자라는데 며칠이 걸리는지 정확하게 알고 있다.
 * 모든 나무가 완전히 자란 이후에 이장님을 초대해야 한다.
 * 즉, 마지막 나무가 다 자란 다음날 이장님을 초대할 것이다.
 * 나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대하려고 한다면 며칠에 초대할 수 있을까
 *
 * 묘목의 수 1 <= N <= 100,000
 * 나무가 자라는데 며칠이 걸리는지 1 <= t 1,000,000
 * 묘목을 구입한 날이 1일이다.
 * 답이 여러가지인 경우에는 가장 작은 값을 출력한다.
 * 묘목의 개수가 최대 10만개이기 때문에 O(N^2) 시간복잡도는 실패할 수 있다.
 *
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());                    // 묘목의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());    // 다 자라는데 걸리는 날짜
        Integer[] arr = new Integer[n];         // 자라는데 걸리는 날짜를 저장할 배열

        // 자라는데 걸리는 날짜를 배열에 저장한다.
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 걸리는 날짜를 기준으로 내림차순 정렬
        Arrays.sort(arr, Comparator.reverseOrder());

        // 묘목을 구입한 날이 1일이기 때문에 i에 1을 더한 뒤 묘목이 자라는 날짜를 더해서 배열에 저장한다.
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) + (arr[i]);
        }

        // 다시 걸리는 날짜를 기준으로 내림차순 정렬을 한다.
        Arrays.sort(arr, Comparator.reverseOrder());

        // 나무가 완전히 자란 다음날 이장님을 초대할 것이기 때문에 1을 더해주고 출력한다.
        System.out.println(arr[0] + 1);
    }
}
