package 프로그래머스.first;

public class 이상한_문자_만들기 {

    public static String test(String s) {
        String[] strArr = s.split("");
        StringBuilder sb = new StringBuilder();

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

            sb.append(strArr[i]);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(test("try hello world"));
    }
}
