package 프로그래머스;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex_1 {

    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int index = 0;
        int count = 0;
        int end = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= end) {
                queue.add(jobs[index++]);
            }

            if (queue.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] job = queue.poll();
                answer += job[1] + end - job[0];
                end += job[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }
}
