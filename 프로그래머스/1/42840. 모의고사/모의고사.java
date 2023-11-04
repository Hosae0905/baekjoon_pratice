import java.util.*;
import java.io.*;


class Solution {
    public int[] solution(int[] answers) {  // 정답지 answer

        // 맞힌 개수를 저장할 배열
        int[] count = {0, 0, 0};

        // 1. 수포자 3인방 입력 받기
        int[] personA = {1, 2, 3, 4, 5};     // 찍는 답이 5개씩 반복됨
        int[] personB = {2, 1, 2, 3, 2, 4, 2, 5};    // 찍는 답이 8개씩 반복됨
        int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 찍는 답이 10개씩 반복됨

        // 2. 수포자의 답안지와 정답지 answer를 비교 --> 몇 개 맞았는지 카운트
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == personA[i % 5]) count[0]++;        // 1 3 2 4 2    count [2, 1, 1]
            if(answers[i] == personB[i % 8]) count[1]++;
            if(answers[i] == personC[i % 10]) count[2]++;
        }

        // 4. 최대 점수 구하기
        int max = Math.max(count[0], Math.max(count[1], count[2]));


        // 3. 많이 맞은 순서대로 배열에 담기
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < 3; i++) {
            if(max == count[i]) list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        // 4. 츨력
        return answer;
    }
}