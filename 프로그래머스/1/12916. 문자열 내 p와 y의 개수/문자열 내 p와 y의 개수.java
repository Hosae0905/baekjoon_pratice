class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0;
        int y = 0;

        String upperCase = s.toUpperCase();
        char[] charArray = upperCase.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'P') p++;
            else if (charArray[i] == 'Y') y++;
        }

        if (p == y) return answer;
        else return false;
    }
}