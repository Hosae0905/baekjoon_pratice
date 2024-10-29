import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/**
 * 백준 1427번
 * 간단한 내림차순 정렬 문제이다.
 * 정렬하려고 하는 수 N이 주어지는데 10억보다 작거나 같은 자연수이다.
 *
 * 입력값을 문자열로 받아서 일반 문자로 나눈 뒤 정렬을 진행한다.
 * 문자열로 정렬을 진행하면 10억이라도 10개의 문자로 나눌 수 있기 때문에 시간 복잡도를 크게 고려하지 않아도 된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();     // 입력값을 저장할 문자열 변수

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }

        Collections.sort(list);

        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}
