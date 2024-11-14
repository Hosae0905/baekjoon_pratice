import java.io.*;
import java.util.*;
/**
 * 백준 1380번
 * 귀걸이를 받지 못한 소녀의 이름을 알려줘야 한다.
 * 압수한 귀걸이는 여학생 번호와 마음대로 선택한 A또는 B가 적혀있다.
 *
 * 귀걸이를 압수당한 여학생 수 N: 1 <= N <= 1000
 * 여학생 이름은 최대 60자
 * 2n - 1줄에 여학생 번호와 A 또는 B가 주어진다.
 * 처음 등장하는 것은 압수되었음을, 두 번째로 등장하는 것은 돌려받았음을 의미한다.
 * 0을 마지막 줄로 하여 종료된다.
 */

class Student {
    int number;
    String name;
    int count;

    Student(int number, String name) {
        this.number = number;
        this.name = name;
        this.count = 0;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int index = 1;

        while (!str.equals("0")) {
            int n = Integer.parseInt(str);

            Student[] arr = new Student[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new Student(i, br.readLine());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.countTokens() > 1) {
                int num = Integer.parseInt(st.nextToken());
                String word = st.nextToken();

                arr[num].count++;
                st = new StringTokenizer(br.readLine());
            }

            for (int i = 1; i < arr.length; i++) {
                if (arr[i].count < 2) {
                    sb.append(index).append(" ").append(arr[i].name).append("\n");
                    index++;
                }
            }

            str = st.nextToken();
        }

        System.out.println(sb.toString());
    }
}
