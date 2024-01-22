import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int count = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                count++;
            }
            queue.add(count);
        }

        int complete = 0;
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

        int[] result = new int[list.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }


        return result;
    }
}