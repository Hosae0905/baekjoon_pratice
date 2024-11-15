import java.io.*;
import java.util.*;

/**
 * 백준 1439번
 * 0과 1로 이루어진 문자열을 뒤집어서 모든 숫자를 전부 같게 만들려고 한다.
 * 연속된 하나 이상의 숫자를 잡고 모두 뒤집을 수 있다. 1을 0으로, 0을 1로 뒤집는다.
 * 문자열 S가 주어질때 숫자를 모두 같게 만들 수 있는 최소 횟수를 출력해라.
 *
 * 문자열 S의 길이는 100만보다 작다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str, "0");
        StringTokenizer st2 = new StringTokenizer(str, "1");
        System.out.println(Math.min(st1.countTokens(), st2.countTokens()));
    }
}
