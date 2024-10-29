import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 백준 1181번
 * 길이가 짧은 것부터 만약 길이가 같으면 사전 순으로 정렬
 * 중복된 단어는 하나만 남기고 제거
 *
 * 단어의 개수 N은 1보다 크거나 같고 2만보다 작거나 같다.
 * 주어지는 문자열의 길이는 50을 넘기지 않는다.
 *
 * 중복은 없어야 하고 길이가 같으면 사전 순으로 정렬이 필요하다. --> TreeSet으로 풀어보자.
 */

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 단어의 개수
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {      // 단어를 저장할 TreeSet
            @Override
            public int compare(String o1, String o2) {
                /*
                * 만약 문자열의 길이가 같다면 사전 순으로 정렬을 한다.
                * 그렇지 않다면 길이가 짧은 것부터 정렬한다.
                * */
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        // 입력받는 문자열을 하나씩 TreeSet에 저장한다.
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            treeSet.add(str);
        }

        // TreeSet에 저장된 문자열을 하나씩 출력한다.
        for (String str : treeSet) {
            System.out.println(str);
        }
    }
}