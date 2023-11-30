import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int count = 0;

        for (int time : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(time);
                    sum += time;
                    count++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + time > weight) {
                        queue.add(0);
                        count++;
                    } else {
                        queue.add(time);
                        sum += time;
                        count++;
                        break;
                    }
                }
            }
        }
        return count + bridge_length;
    }
}