class Solution {
    public String solution(String[] seoul) {
        int place = 0;

        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].startsWith("Kim")) {
                place = i;
                break;
            }
        }

        return "김서방은 " + place + "에 있다";
    }
}