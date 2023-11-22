class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Double sqrt = Math.sqrt(n);
        if (sqrt.intValue() ==  sqrt) {
            return (long)Math.pow(++sqrt, 2);
        } else {
            return -1;
        }
    }
}