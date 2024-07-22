package week_2.kyoul10121;

import java.util.Collections;
import java.util.PriorityQueue;

public class PGS_프로세스 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }
    public static int solution(int[] priorities, int location) {
        //내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        //우선순위 큐에 우선순위 요소 추가
        for(int i : priorities) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {  //큐가 빌 때까지 반복
            for(int i = 0; i < priorities.length; i++){ //기존 우선순위 배열 순회
                if(priorities[i] == queue.peek()){    //현재 작업의 위치 찾기
                    queue.poll();   // 큐에서 우선순위가 가장 높은 프로세스를 꺼냄
                    answer++;       // 실행된 프로세스의 순서를 증가
                    if (location == i)  {   //현재 작업이 location과 같으면 answer 반환
                        return answer;
                    }
                }
            }
        }
        return answer;

    }
}
