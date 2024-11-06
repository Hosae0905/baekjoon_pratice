import java.io.*;
import java.util.*;
/**
 * 백준 8979번
 * 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.
 *
 * 1. 금메달 수가 더 많은 나라
 * 2. 금메달 수가 같으면 은메달 수가 더 많은 나라
 * 3. 금, 은메달 수가 모두 같으면 동메달 수가 더 많은 나라
 *
 * 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다.
 * 예를 들어 두 나라가 모두 메달이 같다면 공동 1등이 되고 다음 등수는 3등이 된다.
 * 어느 국가가 몇등을 했는지 출력해라.
 *
 * 국가의 수 N: 1 <= N <= 1,000
 * 등수를 알고 싶은 국가 K: 1 <= K <= N
 * 전체 메달 수의 총합은 1,000,000 이하
 */

/**
 * 국가별 메달 개수 정보를 담을 클래스
 */
class Country {
    int num;
    int gold;
    int silver;
    int bronze;
    int grade;

    Country(int num, int gold, int silver, int bronze, int grade) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        // 만약 매개변수가 null이라면 false를 반환한다.
        if (obj == null) {
            return false;
        }

        Country country = (Country) obj;        // 매개변수로 받은 obj를 Country 객체로 타입 캐스팅을 한다.

        /*
        * 만약 금메달, 은메달, 동메달이 같다면 동일한 등수이기 때문에 true를 반환한다.
        * 그렇지 않다면 다른 등수이기 때문에 false를 반환한다.
        * */
        if (this.gold == country.gold && this.silver == country.silver && this.bronze == country.bronze) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());       // 총 국가 수
        int k = Integer.parseInt(st.nextToken());       // 등수를 알고 싶은 국가의 번호

        ArrayList<Country> list = new ArrayList<>();        // 국가별 메달 정보를 담을 리스트

        // 국가별 금메달, 은메달, 동메달 정보를 Country 객체로 만들어 리스트에 저장한다.
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());         // 국가 번호
            int gold = Integer.parseInt(st.nextToken());        // 금메달 개수
            int silver = Integer.parseInt(st.nextToken());      // 은메달 개수
            int bronze = Integer.parseInt(st.nextToken());      // 동메달 개수
            list.add(new Country(num, gold, silver, bronze, 0));   // Country 객체를 리스트에 저장
        }

        // 국가별 메달 개수를 통해 내림차순 정렬을 한다.
        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                /*
                * 만약 금메달 개수가 같다면 은메달 개수를 기준으로 내림차순 정렬을 한다.
                * 그렇지 않고 금메달 개수와 은메달 개수가 같다면 동메달 개수를 기준으로 내림차순 정렬을 한다.
                * 그렇지 않으면 금메달 개수를 기준으로 내림차순 정렬을 한다.
                * */
                if(o2.gold == o1.gold) {
                    if (o2.silver == o1.silver) {
                        return o2.bronze - o1.bronze;
                    } else {
                        return o2.silver - o1.silver;
                    }
                } else {
                    return o2.gold - o1.gold;
                }
            }
        });

        list.get(0).grade = 1;
        int find = 0;


        /*
        * 만약 가장 앞에 있는 나라가 찾고자 하는 나라라면 1등이기 때문에 바로 출력을 해준다.
        * 그렇지 않다면 찾고자 하는 국가를 리스트에서 찾는다.
        * */
        for (int i = 1; i < list.size(); i++) {
            Country now = list.get(i);
            Country prev = list.get(i - 1);

            if (list.get(i).num == k) {
                find = i;
            }

            if (now.equals(prev)) {
                now.grade = prev.grade;
                continue;
            } else {
                now.grade = i + 1;
            }
        }

        System.out.println(list.get(find).grade);
    }
}
