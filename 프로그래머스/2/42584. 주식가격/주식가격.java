import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            queue.add(prices[i]);
        }

        int[] answer = new int[prices.length];
        int index = 0;
        while (!queue.isEmpty()) {
            int currentPrice = queue.poll();
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {
                if (currentPrice > prices[i]) {
                    answer[index]++;
                    break;
                } else if (currentPrice <= prices[i]) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}