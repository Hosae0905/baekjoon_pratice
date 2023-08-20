package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Silver4_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.offer(temp);
        }

        System.out.println(queue.poll());
    }
}
