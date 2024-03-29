import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] intArr = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = new int[commands[i][1] - (commands[i][0] - 1)];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = array[j + (commands[i][0] - 1)];
            }
            Arrays.sort(temp);
            intArr[i] = temp[commands[i][2] - 1];
        }

        return intArr;
    }
}