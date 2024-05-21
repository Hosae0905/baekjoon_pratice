import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int index = deque.indexOf(arr[i]);
            int half_index = 0;

            if (deque.size() % 2 == 0) {
                half_index = deque.size() / 2 - 1;
            } else {
                half_index = deque.size() / 2;
            }

            if (index <= half_index) {
                for (int j = 0; j < index; j++) {
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - index; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);

    }
}
