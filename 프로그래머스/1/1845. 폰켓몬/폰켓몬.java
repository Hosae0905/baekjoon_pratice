import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        Set<Integer> ponketmon = new HashSet<>();

        for (int num : nums) {
            ponketmon.add(num);
        }

        if (ponketmon.size() > max) {
            return max;
        } else {
            return ponketmon.size();
        }
    }
}