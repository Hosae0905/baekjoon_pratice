import java.io.*;
import java.util.*;

/**
 * 백준 1543번
 * 문서에서 특정 단어가 중복되지 않고 총 몇 번 등장하는지 세는 프로그램
 *
 * 문서의 길이는 최대 2500
 * 검색하고 싶은 단어의 길이는 최대 50
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();        // 문서를 입력 받아 변수에 저장
        String str2 = br.readLine();        // 검색할 문자열을 입력 받아 변수에 저장

        int size1 = str1.length();          // 문서의 길이를 변수에 저장
        int size2 = str2.length();          // 검색할 문자열의 길이를 변수에 저장

        str1 = str1.replace(str2, "");      // 문서에서 검색할 문자열 부분을 모두 제거한 뒤 다시 변수에 저장
        
        // 기존의 문서 길이에 검색할 문자열을 지운 문서의 크기를 빼주고 검색할 문자열의 길이만큼 나눠준다.
        System.out.println((size1 - str1.length()) / size2);
    }
}
