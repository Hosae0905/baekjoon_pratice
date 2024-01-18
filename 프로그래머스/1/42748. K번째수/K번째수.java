import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        List<Integer> temp = new ArrayList<>();
        List<Integer> branch = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
                temp.add(array[j]);
            }
            Collections.sort(temp);
            branch.add(temp.get(commands[i][2] - 1));
            temp.clear();
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = branch.get(i);
        }
        return result;
    }
}