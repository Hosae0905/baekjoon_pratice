import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int value = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (value > prices[j]) {
                    answer[i]++;
                    break;
                } else {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}