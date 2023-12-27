import java.util.*;

class Solution {
    static List<String> list;
    static String[] match = { "A", "E", "I", "O", "U" };

    public int solution(String word) {
        int answer = 0;

        list = new ArrayList<>();
        dfs("", 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    private void dfs(String str, int length) {
        list.add(str);
        if (length == 5) return;
        for (int i = 0; i < 5; i++) {
            dfs(str + match[i], length + 1);
        }
    }
}