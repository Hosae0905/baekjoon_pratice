import java.io.*;
import java.util.*;
/**
 * 수 N개가 주어졌을 때 오름차순 정렬하여 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성해라.
 *
 * N = 1 <= N <= 5,000,000
 * K = 1 <= K <= N
 *
 * 500만개 되는 데이터를 오름차순 정렬하는데 O(n^2)의 시간복잡도는 시간 초과가 난다.
 * 메서드를 활용하여 오름차순을 하고 데이터를 찾아보자.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());       // 수의 개수
        int k = Integer.parseInt(st.nextToken());       // 찾으려고 하는 숫자의 위치

        int[] arr = new int[n];     // 수의 개수만큼 배열을 생성한다.
        st = new StringTokenizer(br.readLine());

        // 배열에 입력으로 받은 데이터를 저장한다.
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 메서드를 활용하여 배열을 오름차순으로 정렬한다.
        Arrays.sort(arr);

        // 인덱스가 0부터 시작하기 때문에 출력할때 1을 빼준 인덱스 위치를 출력한다.
        System.out.println(arr[k - 1]);
    }
}
