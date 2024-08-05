class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");

        int index = 0;

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(" ")) {
                index = 0;
            } else if (index % 2 == 0) {
                strArr[i] = strArr[i].toUpperCase();
                index++;
            } else {
                strArr[i] = strArr[i].toLowerCase();
                index++;
            }

            answer += strArr[i];
        }

        return answer;

    }
}