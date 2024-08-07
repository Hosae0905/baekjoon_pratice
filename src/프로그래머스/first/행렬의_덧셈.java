package 프로그래머스.first;

import java.util.Arrays;

public class 행렬의_덧셈 {

    public static int[][] test(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {4, 5}};

        int[][] result = test(arr1, arr2);
        System.out.println(Arrays.deepToString(result));
    }
}
