import java.io.*;
import java.util.*;

/**
 * 백준 1251번
 * 주어진 단어를 임의의 두 부분을 골라서 단어를 쪼갠다.
 * 쪼개진 문자열은 적어도 길이가 1 이상인 단어여야 한다.
 * 이렇게 나눈 세 개의 작은 단어들을 앞뒤로 뒤집고 이를 다시 원래의 순서대로 합친다.
 * 이렇게 만들 수 있는 단어 중에서 사전순으로 가장 앞서는 단어를 출력하는 프로그램을 만들어라.
 *
 * 입력으로 주어지는 단어는 길이가 3이상 50이하다.
 * 단어를 나눈다 --> substring() 메서드 사용
 * 문자열을 뒤집는다 --> StringBuilder 클래스의 reverse() 메서드 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();                     // 단어를 입력받아 변수에 저장
        ArrayList<String> list = new ArrayList<>();     // 뒤집은 단어들을 저장할 리스트

        /**
         * 단어의 길이만큼 반복하며 임의의 두 부분을 골라 쪼갠다.
         * 쪼갠 단어들을 뒤집고 다시 이어붙여 리스트에 저장한다.
         * 단어의 길이는 무조건 1 이상이어야 하기 때문에 i는 1부터, j는 i + 1부터 시작한다.
         */
        for(int i = 1; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                StringBuilder first = new StringBuilder(str.substring(0, i)).reverse();     // 0부터 i까지 단어를 쪼갠 뒤 뒤집는다.
                StringBuilder second = new StringBuilder(str.substring(i, j)).reverse();    // i부터 j까지 단어를 쪼갠 뒤 뒤집는다.
                StringBuilder third = new StringBuilder(str.substring(j)).reverse();        // j이후부터 단어를 뒤집는다.

                StringBuilder result = new StringBuilder();
                result.append(first).append(second).append(third);      // 뒤집어진 단어들을 다시 하나로 이어붙인다.
                list.add(result.toString());        // 이어붙인 단어를 리스트에 저장한다.
            }
        }

        // 사전 순으로 정렬을 한다.
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
