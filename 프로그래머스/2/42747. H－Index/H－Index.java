import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < citations.length; i++) {
            list.add(citations[i]);
        }

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(0) == 0) {
                return 0;
            } else if (list.get(i) <= i) {
                break;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}