import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();

            if (action.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (action.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (action.equals("pop_front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else {
                    int num = deque.pollFirst();
                    sb.append(num).append("\n");
                }
            } else if (action.equals("pop_back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else {
                    int num = deque.pollLast();
                    sb.append(num).append("\n");
                }
            } else if (action.equals("size")) sb.append(deque.size()).append("\n");
            else if (action.equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (action.equals("front")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (action.equals("back")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
