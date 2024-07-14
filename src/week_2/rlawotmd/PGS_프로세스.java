package week_2.rlawotmd;

import java.util.*;

public class PGS_프로세스 {
    static int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        //Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2)); // 우선 순위로 처리를 하기에 PQ를 활용

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] {priorities[i], i + 'A'});
            pq.offer(priorities[i]);
        }

        while (!q.isEmpty() && !pq.isEmpty()) {
            int[] arr = q.poll();
            if (pq.peek() == arr[0]) { // Q가 비어있을 때 remove는 Exception 발생, poll은 null을 반환
                answer++;
                pq.poll();
                if (location + 'A' == arr[1]) return answer;
            }
            q.offer(arr);
            // while 제일 앞과 제일 뒤의 두줄이랑 q.offer(q.poll);랑 뭐가 다른지 모르겠다....
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = new int[] {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution(priorities, location));

        priorities = new int[] {1, 1, 9, 1, 1, 1};
        location = 0;
        System.out.println(solution(priorities, location));
    }
}
// ArrayDeque = 0.7 ~ 1.4 ms
// Queue = 0.8 ~ 2.2 ms