import java.io.*;
import java.util.*;

/**
 * 백준 1769번
 * 양의 정수 X는 3의 배수인지 확인하는 프로그램
 * 입력으로 들어온 정수 X의 각 자릿수를 모두 더한 수 Y를 만든다.
 * 그런 다음 Y가 3의 배수인지 확인한다.
 * Y가 한 자리 수가 되는 순간까지 정수를 몇번 변환하는지와 해당 정수가 3의 배수인지 확인해라.
 *
 * 입력으로 큰 자연수 X가 주어지는데 X는 100만자리 이하의 수다.
 * 수는 0으로 시작하지 않는다.
 * 3의 배수면 YES, 아니면 NO를 변환 횟수와 같이 출력한다.
 */
public class Main {

    static int count = 0;           // 몇번 변환했는지 확인할 변수
    static String str = "";         // 입력 값을 저장할 변수


    /**
     * 입력 값이 한 자리가 될 때까지 각 자리수를 더하고 변환 횟수를 카운팅할 메서드
     */
    static void sum() {
        int num = 0;        // 각 자리수의 합을 저장할 변수

        // 만약 입력 값이 한 자리가 된다면 변환 과정을 마친 것이기 때문에 메서드를 종료한다.
        if (str.length() == 1) {
            return;
        }

        // 입력 값의 길이만큼 반복하면서 각 자리수를 더해 num 변수에 저장한다.
        for (int i = 0; i < str.length(); i++) {
            num += str.charAt(i) - '0';
        }

        count++;        // 변환을 거쳤기 때문에 카운트를 올린다.
        str = String.valueOf(num);      // 각 자리수의 합을 다시 문자열로 만들어 str 변수에 저장한다.
        sum();          // 다시 재귀함수를 호출한다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();        // 입력 값을 받는다.
        StringBuilder sb = new StringBuilder();     // 결과를 출력할 변수

        sum();      // 재귀함수 호출
        sb.append(count).append("\n");      // 몇번 변환 과정을 거쳤는제 횟수를 sb에 저장한다.

        /**
         * {@code true} str(한 자리수)이 3의 배수면 YES를 sb에 저장한다.
         * else {@code false} 그렇지 않다면 sb에 NO를 저장한다.
         */
        if (Integer.parseInt(str) % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }

        System.out.println(sb.toString());
    }
}
