import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Main {
    public static boolean isMoWord(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";

        while(!(str = br.readLine()).equals("end")) {
            boolean check = false;
            int count = 0;
            char prev = '.';
            char[] arr = str.toCharArray();

            for (char c : arr) {
                if (isMoWord(c)) {
                    check = true;
                }

                if (!(isMoWord(c) == isMoWord(prev))) {
                    count = 1;
                } else {
                    count++;
                }

                if (count > 2 || (prev == c && (c != 'e' && c != 'o'))) {
                    check = false;
                    break;
                }

                prev = c;
            }


            if (check) {
                sb.append("<").append(str).append("> ").append("is ").append("acceptable.\n");
            } else {
                sb.append("<").append(str).append("> ").append("is not ").append("acceptable.\n");
            }
        }

        System.out.println(sb.toString());

    }
}
