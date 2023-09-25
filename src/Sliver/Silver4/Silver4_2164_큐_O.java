package Sliver.Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver4_2164_큐_O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();               // 첫 번째 카드 버리기
            int temp = queue.poll();    // 두 번째 카트 뽑기
            queue.offer(temp);          // 두 번째 카드를 큐에 삽입하기
        }

        System.out.println(queue.poll());   // 마지막으로 남은 카드 뽑기
    }
}
