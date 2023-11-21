import java.util.*;

public class Solution {
    public int solution(int num) {
        int answer = 0;

        while (num > 0) {
            answer += num % 10;
            num /= 10;
        }

        return answer;
    }
}