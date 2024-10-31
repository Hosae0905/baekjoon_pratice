import java.io.*;
import java.util.*;
/**
 * 백준 2993번
 * 단어를 세부분으로 나눈다.
 * 세 부분으로 나눈 단어를 각각 순서를 뒤집는다.
 * 세 단어를 다시 합친다.
 * 그렇게 해서 만든 단어 중 가장 앞서는 단어를 출력해라.
 *
 * 단어의 길이는 3보다 크거나 같고, 50보다 작거나 같다.
 * 시간복잡도를 크게 고려하지 않아도 무방할 것 같다.
 * Ex_2와 유사한 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();                     // 단어를 입력 받는다.
        ArrayList<String> list = new ArrayList<>();     // 단어의 조합을 저장할 리스트

        // 단어를 세 부분으로 나눠가면서 문자를 조합한다.
        for (int i = 2; i < str.length(); i++) {
            for(int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(str.substring(0, j));     // 0부터 j까지 문자를 자른다.
                StringBuilder sb2 = new StringBuilder(str.substring(j, i));     // j부터 i까지 문자를 자른다.
                StringBuilder sb3 = new StringBuilder(str.substring(i));        // i부터 나머지까지 문자를 자른다.
                String str1 = sb1.reverse().toString();     // 자른 문자를 뒤집어서 변수에 저장한다.
                String str2 = sb2.reverse().toString();
                String str3 = sb3.reverse().toString();

                list.add(str1 + str2 + str3);       // 다시 세 단어를 나누기 전과 같은 순서로 합쳐 하나로 만든다.
            }
        }

        // 사전 순으로 정렬시킨다.
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
