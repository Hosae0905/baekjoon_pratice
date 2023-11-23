class Solution {
    public int solution(int num) {
        int count = 0;
        long test = (long)num;

        if (test == 1) {
            return 0;
        }

        while (test > 1) {
            if (test % 2 == 0) {
                test /= 2;
                count++;
            } else if (test % 2 == 1) {
                test = (test * 3) + 1;
                count++;
            }
        }

        if (count >= 500) {
            return -1;
        } else {
            return count;
        }
    }
}