class Solution {
    public long solution(int a, int b) {
        long sum = 0;

        if (a == b) {
            return (long)a;
        } else if (a < b) {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        } else {
            for (int i = a; i >= b; i--) {
                sum += i;
            }
        }
        return sum;
    }
}