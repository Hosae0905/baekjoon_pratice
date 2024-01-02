import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> result = new HashMap<>();

        for (String key : participant) {
            result.put(key, result.getOrDefault(key, 0) + 1);
        }

        for (String com : completion) {
            result.put(com, result.get(com) - 1);
        }

        for (String key : result.keySet()) {
            if (result.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}