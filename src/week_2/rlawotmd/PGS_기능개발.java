package week_2.rlawotmd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_기능개발 {
    static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            q.offer(progresses[i]); // 진도를 순서대로 Q에 저장
        }

        List<Integer> l = new ArrayList<>(); // 앞의 기능이 배포되지 않으면 뒤에 있는 기능도 배포를 못하기에 FIFO를 활용
        int point = 0; // 앞의 기능이 끝나면 뒤에 있는 기능만 개발하면 되기에 포인터 변수를 활용

        while (!q.isEmpty()) {
            int cnt = 0;

            for (int i = point; i < progresses.length; i++) { //
                q.offer(q.poll() + speeds[i]);
            }

             while (!q.isEmpty() && q.peek() >= 100) { // Q를 앞에서 부터 확인하며, 값이 100이 넘을 경우 답을 추가
                 q.poll(); // 완료된 프로그램은 remove 후 cnt 증가
                 cnt++;
             }

            if (cnt > 0) { // cnt가 1이상일 경우 하나의 기능이 배포됐다는 것이기에 정답 배열에 추가 후, point에 적용
                l.add(cnt);
                point += cnt;
            }
        }

        answer = l.stream().mapToInt(i -> i).toArray(); // List -> Array로 변환

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[] {93, 30, 55};
        int[] speeds = new int[] {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

        progresses = new int[] {95, 90, 99, 99, 80, 99};
        speeds = new int[] {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}

// 2 ~ 4.5 ms

