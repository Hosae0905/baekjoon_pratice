import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        int complete = 0;
        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            queue.add(count);
        }
        Integer value = queue.poll();
        while (!queue.isEmpty()) {
            if (value < queue.peek()) {
                complete++;
                list.add(complete);
                complete = 0;
                value = queue.poll();
                if (queue.isEmpty()) {
                    complete++;
                    list.add(complete);
                }
            } else {
                complete++;
                queue.poll();
                if (queue.isEmpty()) {
                    complete++;
                    list.add(complete);
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}