package 프로그래머스.first;

import java.util.Arrays;

public class 예산 {

    public static int test(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        Arrays.sort(d);

        for (int value : d) {
            total += value;
            if (total > budget) {
                return answer;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3};
        int test = test(arr, 10);
        System.out.println("test = " + test);
    }
}
