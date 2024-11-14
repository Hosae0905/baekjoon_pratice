import java.io.*;
import java.util.*;

/**
 * 백준 1316번
 * 그룹단어란 단어에 존재하는 모든 문자에 대해서 각 문자가 연속해서 나타나는 경우를 말한다.
 * 특정 단어가 연속되지 않고 떨어져서 나타난다면 그룹 단어가 아니다.
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력해라.
 *
 * 단어의 개수 N: 0 < N <= 100
 * 단어는 소문자로만 되어 있고 중복되지 않으며 길이는 최대 100이다.
 */
public class Main {

    /**
     * 그룹 단어인지 확인하는 메서드
     * @param str 입력한 단어
     * @return  {@code true} 그룹 단어가 맞을 경우,
     *          else {@code false} 그룹 단어가 아닐 경우
     */
    public static boolean check(String str) {
        boolean[] check = new boolean[26];      // 이미 단어가 나왔는지 확인할 배열(알파벳은 총 26개)
        int prev = 0;       // 이전 단어를 저장할 변수

        // 입력 받은 문자열의 길이만큼 단어를 체크한다.
        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);        // 현재 단어가 무엇인지 저장한다.

            /**
             * 만약 이전 단어와 현재 단어가 일치하지 않을 경우(연속되지 않은 경우) 현재 단어가 나온적이 있는지 확인한다.
             * 그렇지 않다면(즉, 단어가 연속적이라면) 반복문을 계속 진행한다.
             */
            if (prev != now) {
                /**
                 * 만약 현재 단어가 아직 나온적이 없는 경우 true를 저장하고, 이전 단어에 현재 단어를 저장한다.
                 * 그렇지 않다면 이미 나온적이 있다는 의미로 그룹 단어가 아니기 때문에 false 반환한다.
                 */
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 단어의 총 개수
        int count = 0;          // 그룹 단어가 몇개인지 저장할 변수

        // n개의 단어를 하나씩 받아서 그룹 단어인지 체크한다.
        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            // 만약 그룹 단어가 맞다면 count를 1 증가시켜준다.
            if (check(str)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
