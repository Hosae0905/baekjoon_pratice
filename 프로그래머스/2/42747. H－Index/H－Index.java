import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] test = new Integer[citations.length];

        for (int i = 0; i < citations.length; i++) {
            test[i] = citations[i];
        }

        Arrays.sort(test, Collections.reverseOrder());

        if (test[0] == 0) return 0;

        for (int i = 0; i < test.length; i++) {
            if (test[i] <= i) {
                break;
            } else {
                answer++;
            }
        }

        return answer;
    }
}