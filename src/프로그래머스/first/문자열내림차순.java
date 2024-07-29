package 프로그래머스.first;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순 {

    public static String test(String s) {
        /*String answer = "";

        String[] str = s.split("");

        Arrays.sort(str, Collections.reverseOrder());

        for (String word : str) {
            answer += word;
        }

        return answer;*/

        StringBuilder sb = new StringBuilder();

        String[] str = s.split("");

        Arrays.sort(str, Collections.reverseOrder());

        for (String word : str) {
            sb.append(word);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(test("Zbcdefg"));
    }
}
