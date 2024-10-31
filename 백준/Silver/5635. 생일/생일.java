import java.io.*;
import java.util.*;
/**
 * 백준 5635번
 * 가장 나이가 적은 사람과 많은 사람을 구하기
 * 학생 수 n(1 <= n <= 100)
 * 이름 | 날짜(1 <= dd <= 31) | 월(1 <= mm <= 12) | 년도(1990 <= yyyy <= 2010) 형식으로 주어짐
 *
 * 첫째 줄에 가장 나이가 적은 사람
 * 둘째 줄에 가장 나이가 많은 사람
 *
 * 학생 수가 최대 100명이기 때문에 시간복잡도를 크게 고려하지 않아도 무방함
 */

class Member {
    String name;
    int year;
    int month;
    int day;

    Member(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        // 총 학생 수
        StringTokenizer st;
        ArrayList<Member> list = new ArrayList<>();     // 학생 정보를 담을 리스트

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();                   // 학생 이름
            int day = Integer.parseInt(st.nextToken());     // 출생 년도
            int month = Integer.parseInt(st.nextToken());   // 출생 월
            int year = Integer.parseInt(st.nextToken());    // 출생 일

            list.add(new Member(name, day, month, year));   // 학생 객체를 만들어 리스트에 저장
        }

        // 1. 정렬하기
        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                /*
                * 만약 년도와 월이 같다면 일을 기준으로 오름차순 정렬한다.
                * 그렇지 않고 만약 년도만 같다면 월을 기준으로 오름차순 정렬한다.
                * 그렇지 않다면 년도를 기준으로 오름차순 정렬한다.
                * */
                if(o1.year == o2.year && o1.month == o2.month) {
                    return o2.day - o1.day;
                } else if(o1.year == o2.year) {
                    return o2.month - o1.month;
                } else {
                    return o2.year - o1.year;
                }
            }
        });

        // 2. 출력하기
        System.out.println(list.get(0).name);
        System.out.println(list.get(n - 1).name);
    }
}
