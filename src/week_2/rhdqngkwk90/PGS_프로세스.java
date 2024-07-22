package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_프로세스 {

    static int[] priorities = {1, 1, 9, 1, 1, 1};
    static int location = 0;

    public static void main(String[] args) {
        int answer = solution(priorities, location);
        //return answer;
        System.out.println(answer);
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;

        //우선순위 큐 - 내림 차순 선언
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        //큐에 넣기
        for (int i : priorities) q.offer(i);

        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            //배열 순회
            for (int j = 0; j < priorities.length; j++) {
                //현재 작업의 위치 찾기
                if (q.peek() == priorities[j]) {
                    q.poll();
                    answer++;
                    //현재 작업이 location과 같으면 answer 반환
                    if (location == j) return answer;
                }
            }
        }
        return answer;
    }
}
