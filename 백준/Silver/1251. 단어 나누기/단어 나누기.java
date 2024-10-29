import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
/**
 * 백준 1251번
 * 단어에서 임의의 두 부분을 골라서 쪼갠다.  --> 무조건 3개의 문자열이 나온다.
 * 각각은 적어도 길이가 1 이상인 단어여야 한다.
 * 나눈 세 개의 작은 단어들을 앞뒤로 뒤집고 다시 원래의 순서대로 합친다.
 *
 * 주어지는 단어의 길이는 3 이상 50 이하
 * N을 3으로 나눈뒤 나머지 값과 몫을 더한 값으로 세 부분을 나눈다.
 * ex) 만약 입력값이 8이면 3으로 나눴을때 몫이 2가 나오고 나머지가 2이다.
 *      그러면 2 | 4 | 2 이렇게 세 부분으로 나누면 된다.
 * 입력값이 50이하기 때문에 O(N*2)의 시간복잡도를 가진 정렬을 사용해도 무방하다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();     // 입력값을 저장할 변수

        ArrayList<String> list = new ArrayList<>();     // 단어들의 조합들을 저장할 리스트

        // 세 부분으로 계속 나누면서 문자들의 조합을 구한다.
        for(int i = 2; i < str.length(); i++) {
            for(int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j));
                StringBuilder sb2 = new StringBuilder(str.substring(j, i));
                StringBuilder sb3 = new StringBuilder(str.substring(i));
                String str1 = sb1.reverse().toString();     // 부분적으로 나눈 문자열을 뒤집는다.
                String str2 = sb2.reverse().toString();
                String str3 = sb3.reverse().toString();

                list.add(str1 + str2 + str3);       // 뒤집은 문자열들을 다시 합쳐서 리스트에 저장한다.
            }
        }

        Collections.sort(list);     // 리스트를 사전 순으로 정렬한다.
        System.out.println(list.get(0));        // 가장 맨 앞에 있는 문자열을 출력한다.
    }
}
