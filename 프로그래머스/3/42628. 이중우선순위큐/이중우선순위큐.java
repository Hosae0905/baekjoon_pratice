import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("I")) {
                minQueue.add(Integer.parseInt(operations[i].split(" ")[1]));
                maxQueue.add(Integer.parseInt(operations[i].split(" ")[1]));
            } else if (operations[i].startsWith("D 1")) {
                if (!maxQueue.isEmpty()) {
                    Integer max = maxQueue.peek();
                    minQueue.remove(max);
                    maxQueue.remove(max);
                }
            } else {
                Integer min = minQueue.peek();
                maxQueue.remove(min);
                minQueue.remove(min);
            }
        }

        int[] answer = new int[2];

        if (!maxQueue.isEmpty()) {
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }
        return answer;
    }
}