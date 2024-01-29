import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> people = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            people.put(participant[i], people.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            if (people.containsKey(completion[i])) {
                people.replace(completion[i], people.get(completion[i]) - 1);
            }
        }

        for (String person : people.keySet()) {
            if (people.get(person) > 0) {
                return answer += person;
            }
        }

        return answer;
    }
}