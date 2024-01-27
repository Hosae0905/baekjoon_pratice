import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.add(i);
        }

        int value = 0;
        while (true) {
            if (!queue.isEmpty()) {
                value = queue.poll();
            }

            if (queue.peek() != null) {
                if (value >= K) {
                    break;
                } else {
                    queue.add(value + (queue.poll() * 2));
                    answer++;
                }
            } else {
                break;
            }
        }

        if (value == 0) {
            return -1;
        } else if (value < K){
            return -1;
        } else {
            return answer;
        }
    }
}