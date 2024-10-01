package week_3.rlawotmd;

import java.util.PriorityQueue;

public class PGS_더맵게 {
    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.add((long) scoville[i]);
        }

        int t = 0;
        if (pq.peek() >= K) return 0; // 만약 이미 음식이 지수보다 높다면 바로 리턴

        while (pq.size() > 1) {
            answer++;
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a + (b * 2)); // 계산 후 그 값에 더하는게 아니라 다시 우선순위 큐에 넣어서 계산
            if (pq.peek() >= K) break;
        }

        if (pq.peek() < K) return -1; // 만약 K보다 작다면 -1 리턴

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));

        scoville = new int[]{1, 2, 3};
        K = 0;
        System.out.println(solution(scoville, K));
    }
}
// long을 쓴 이유 : 처음에 문제가 틀렸다고 떴을 때 값이 int의 최대값을 넘는 경우가 있는거 같아 바로 바꿨습니다.
