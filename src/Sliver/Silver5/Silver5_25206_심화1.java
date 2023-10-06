package Sliver.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver5_25206_심화1 {
    public static void main(String[] args) throws IOException {
        // (학점 * 과목평점) / 학점 총합
        // p는 계산에서 제외

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double totalScore = 0;
        double total = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String gradeScore = st.nextToken();

            if (gradeScore.equals("A+")) {
                total += score * 4.5;
                totalScore += score;
            } else if (gradeScore.equals("A0")) {
                total += score * 4.0;
                totalScore += score;
            } else if (gradeScore.equals("B+")) {
                total += score * 3.5;
                totalScore += score;
            } else if (gradeScore.equals("B0")) {
                total += score * 3.0;
                totalScore += score;
            } else if (gradeScore.equals("C+")) {
                total += score * 2.5;
                totalScore += score;
            } else if (gradeScore.equals("C0")) {
                total += score * 2.0;
                totalScore += score;
            } else if (gradeScore.equals("D+")) {
                total += score * 1.5;
                totalScore += score;
            } else if (gradeScore.equals("D0")) {
                total += score * 1.0;
                totalScore += score;
            } else if (gradeScore.equals("F")) {
                total += score * 0.0;
                totalScore += score;
            }
        }

        // 출력
        System.out.printf("%.6f", (total / totalScore));
        
//        // HashMap으로 처리
//        Map<String, Double> hashMap = new HashMap<>();
//        hashMap.put("A+", 4.5);
//        hashMap.put("A0", 4.0);
//        hashMap.put("B+", 3.5);
//        hashMap.put("B0", 3.0);
//        hashMap.put("C+", 2.5);
//        hashMap.put("C0", 2.0);
//        hashMap.put("D+", 1.5);
//        hashMap.put("D0", 1.0);
//        hashMap.put("F", 0.0);
//
//        // 입력
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        double totalScore = 0.0;
//        double total = 0;
//
//        for (int i = 0; i < 20; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            st.nextToken();
//            double score = Double.parseDouble(st.nextToken());
//            String grade = st.nextToken();
//
//            if (grade.equals("P")) continue;
//            double getScore = hashMap.get(grade);
//            totalScore += score * getScore;
//            total += score;
//        }
//
//        // 출력
//        System.out.printf("%.6f", (totalScore / total));
    }
}
