package week_3.rhdqngkwk90;

import java.util.*;

//우선순위 큐 개념 문제
public class PGS_더맵게 {

    //입력
    static int[] scoville = {1, 2, 3, 9, 10, 12};
    static int K = 7;

    //출력
    public static void main(String[] args) {
        int answer = solution(scoville, K);
        System.out.println(answer);
    }

    static int solution(int[] scoville, int K) {
        int answer = 0;

        //우선순위 큐에 입력값 넣기
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i : scoville) heap.offer(i);

        //정렬된 가장 작은 값이 K보다 작으면 반복
        while(heap.peek() < K){
            //큐가 다 비워지지 않으면 스코빌 지수를 K 이상 만들 수 없는 경우
            if(heap.size() == 1) return -1;
            //poll은 꺼냄, peek는 값 확인
            heap.add(heap.poll() + (heap.poll() *2));
            answer++;
        }
        return answer;
    }

}
