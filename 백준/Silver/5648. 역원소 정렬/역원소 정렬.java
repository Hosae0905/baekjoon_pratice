import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * 백준 5648번
 * 모든 원소가 양의 정수인 집합
 * 원소를 거꾸로 뒤집고 그 원소를 오름차순으로 정렬하는 프로그램
 * 단, 원소를 뒤집었을 때 0이 앞에 선행되는 경우 0을 생략
 *
 * 첫 번째로 입력되는 원소값의 개수 n: 1 <= n <= 10^6
 * 입력하는 정수는 10^12가 넘어가지 않는다.
 * 입력하는 줄에는 하나의 원소값 뿐만 아니라 여러 원소값도 들어갈 수 있다.
 *
 * 입력 값이 크기 때문에 문자열로 받아서 처리하자.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 원소의 총 개수
        int count = 0;          // 원소를 카운트할 변수
        StringBuilder[] arr = new StringBuilder[n];
        StringBuilder sb = new StringBuilder();

        while (count < n) {
            if (st.hasMoreTokens()) {
                arr[count] = new StringBuilder();
                arr[count].append(st.nextToken());
                count++;
            } else {
                st = new StringTokenizer(br.readLine());
            }
        }

        for(int i = 0; i < n; i++) {
            StringBuilder str = arr[i].reverse();
            while((str.charAt(0) - '0') == 0) {
                str.deleteCharAt(0);
            }

        }

        Arrays.sort(arr, new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder o1, StringBuilder o2) {
                BigInteger bi1 = new BigInteger(o1.toString());
                BigInteger bi2 = new BigInteger(o2.toString());
                return bi1.compareTo(bi2);
            }
        });

        for(StringBuilder str : arr) {
            sb.append(str.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
