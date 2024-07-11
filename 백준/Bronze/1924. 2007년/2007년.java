import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int totalDay = -1;

        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = new String[365];
        String[] str = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        for (int i = 0; i < days.length; i += 7) {
            for (int j = 0; j < str.length; j++) {
                if (i + j >= 365) {
                    break;
                }
                days[i + j] = str[j];
            }
        }

        if (month == 1) {
            System.out.println(days[totalDay += day]);
        } else {
            for (int i = 0; i < month - 1; i++) {
                totalDay += arr[i];
            }

            System.out.println(days[totalDay += day]);
        }

    }
}
