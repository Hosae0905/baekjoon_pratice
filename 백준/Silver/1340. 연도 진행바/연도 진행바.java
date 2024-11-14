import java.io.*;
import java.util.*;

/**
 * 백준 1340번
 * 이번 해가 얼마나 지났는지 보여주는 애플리케이션
 * 오늘 날짜가 주어지고 이번 해가 몇 %지났는지 출력해야 한다.
 *
 * 첫째 줄에는 month dd, yyyy hh:mm과 같이 주어진다.
 * month는 월이고 yyyy는 현재 연도이다.
 * dd hh mm은 현재 일, 시, 분이다.
 * 연도는 1800보다 크거나 같고 2600보다 작거나 같다.
 * 항상 올바른 날짜와 시간만 입력으로 주어진다.
 *
 * 첫째줄에 문제의 정답을 출력하는데 절대/상대 오차는 10^-9까지 허용된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] monthArr = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] dayArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String month = st.nextToken();
        int day = Integer.parseInt(st.nextToken().replace(",", ""));
        int year = Integer.parseInt(st.nextToken());
        String[] arr = st.nextToken().split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        boolean check = false;
        int index = 0;
        int temp = day;

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            check = true;
        }

        for (int i = 1; i < monthArr.length; i++) {
            if (monthArr[i].equals(month)) {
                index = i;
                break;
            }
        }

        for (int i = 1; i < index; i++) {
            if (check && i == 2) {
                temp += 29;
                continue;
            }

            temp += dayArr[i];
        }

        hour *= 60;
        int totalHM = hour + minute;

        int timeToHour = 60 * 24 * (temp-1) + totalHM;

        int totalTime = 0;
        if (check) {
            totalTime = 366 * 24 * 60;
        } else {
            totalTime = 365 * 24 * 60;
        }

        System.out.println((double) timeToHour * 100 / (double) totalTime);
    }
}
