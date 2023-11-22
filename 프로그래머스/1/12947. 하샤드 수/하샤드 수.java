class Solution {
    public boolean solution(int x) {
        // 1. 정수를 두 개로 나눈다.
        String[] str = String.valueOf(x).split("");
        int[] intArr = new int[str.length];
        int sum = 0;

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(str[i]);
        }

        // 2. 나눈 두 정수를 더한다.
        for (int i = 0; i < intArr.length; i++) {
            sum += intArr[i];
        }

        // 3. 더한 정수를 입력받은 정수로 나눈다. (x / 더한 정수 == 0)
        if ((x % sum) == 0) {
            return true;
        } else {
            return false;
        }
    }
}