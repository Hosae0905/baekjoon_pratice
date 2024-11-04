import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());       // 수의 개수
        k = Integer.parseInt(st.nextToken());       // 찾으려고 하는 숫자의 위치

        int[] arr = new int[n];     // 수의 개수만큼 배열을 생성한다.
        st = new StringTokenizer(br.readLine());

        // 배열에 입력으로 받은 데이터를 저장한다.
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        // 메서드를 활용하여 배열을 오름차순으로 정렬한다.
        Arrays.sort(arr);

        // 인덱스가 0부터 시작하기 때문에 출력할때 1을 빼준 인덱스 위치를 출력한다.
        System.out.println(arr[k - 1]);
    }
}
