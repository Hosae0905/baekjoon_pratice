import java.io.*;
import java.util.*;
/**
 * 백준 10867번
 * N개의 정수를 오름차순으로 졍렬한다.
 * 단, 같은 정수는 한 번만 출력한다.
 *
 * 입력값 N: 1 <= N <= 100,000
 * 주어지는 수는 절댓값이 1,000보다 작거나 같은 정수
 *
 * 입력값이 10만이기 때문에 O(n^2) 보다 좋은 정렬 알고리즘이 필요하다.
 * 중복이 없어야 하기 때문에 TreeSet을 사용하면 중복도 없으면서 정렬도 할 수 있다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 입력 값
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 중복없이 정렬할 수 있는 TreeSet 생성
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            // 오름차순으로 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 숫자 하나씩 TreeSet에 저장
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 정렬된 숫자를 출력
        for(Integer value : set) {
            System.out.print(value + " ");
        }
    }
}
