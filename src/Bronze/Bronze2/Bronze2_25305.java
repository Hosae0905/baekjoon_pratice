package Bronze.Bronze2;

import java.util.Scanner;

public class Bronze2_25305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] people = new int[N];

        for (int i = 0; i < people.length; i++) {
            people[i] = sc.nextInt();
        }

        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1; j++) {
                if (people[j] < people[j+1]) {
                    int temp;
                    temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
            }
        }

        System.out.println(people[K-1]);
    }
}
