import java.io.*;
import java.util.*;
/**
 * 백준 10815번
 * 두 숫자 카드에 같은 번호가 있으면 1 없으면 0을 출력해라.
 *
 * 상근이의 숫자 카드 N: 1 <= N <= 500,000
 * 다른 사람 숫자 카드 M: 1 <= M <= 500,000
 *
 * HashSet을 이용해서 상근이의 숫자 카드를 저장하고 contains로 중복을 확인하면 간단하게 풀 수 있다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 상근이의 카드 개수
        HashSet<Integer> hashSet = new HashSet<>();     // 상근이의 카드를 저장할 자료구조
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();         // 결과를 저장할 StringBuilder

        // 상근이의 카드에 적힌 숫자를 하나씩 hashSet에 저장한다.
        for(int i = 0; i < n; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());        // 다른 사람의 카드 개수
        st = new StringTokenizer(br.readLine());

        // 다른 사람의 카드 개수를 상근이가 가지고 있는지 확인한다.
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());

            /*
            * 만약 다른사람의 카드를 상근이가 가지고 있다면 sb에 1을 저장한다.
            * 그렇지 않다면 sb에 0을 저장한다.
            * */
            if(hashSet.contains(value)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
