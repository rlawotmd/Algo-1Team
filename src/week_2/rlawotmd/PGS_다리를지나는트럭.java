package week_2.rlawotmd;

import java.util.ArrayDeque;

public class PGS_다리를지나는트럭 {
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>(); // Q를 배열로 선언 함으로 [0]번째에는 트럭의 무게, [1]번째에는 현재 이동한 거리를 표현
        int bridge = 0; // 현재 다리에 올라가 있는 무게
        int cnt = 0; // 지나간 트럭 수
        int point = 0; // 트럭 배열을 가르기는 포인트

        while (cnt != truck_weights.length) {
            answer++; // 반복문 마다 정답에 1씩 추가 (시간의 흐름)
            if (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) { // 현재 다리에 있는 트럭들에 한해 이동 거리를 1씩 추가
                    int[] a = q.poll();
                    a[1]++;
                    if (a[1] > bridge_length) { // 만약 다리를 넘었다면 Q에서 제외, 그리고 다리의 무게에서 빼기
                        bridge -= a[0];
                        cnt++;
                    } else q.offer(a); // 아니라면 다시 Q에 추가함으로 다리에 있음을 표현
                }
            }
            if (point < truck_weights.length && bridge + truck_weights[point] <= weight) {
                // 만약 다음 트럭이 가도 다리가 견딜 수 있다면 다음 트럭을 출발
                q.offer(new int[] {truck_weights[point], 1}); // 0부터가 아닌 다리 1부터 시작
                bridge += truck_weights[point++]; // 현재 다리에 올라와 있는 무게 업데이트
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[] {7,4,5,6};
        System.out.println(solution(bridge_length, weight, truck_weights));

        bridge_length = 100;
        weight = 100;
        truck_weights = new int[] {10};
        System.out.println(solution(bridge_length, weight, truck_weights));

        truck_weights = new int[] {10,10,10,10,10,10,10,10,10,10};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
// 0.17 ~ 68.09 ms