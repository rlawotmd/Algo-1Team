package week_2.Jungjuhyeon;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;

public class PGS_다리를지나는트럭 {
    public static void main(String[] args){
        int[] truck_weights1 = new int[] {7,4,5,6};
        int[] truck_weights2 = new int[] {10};
        int[] truck_weights3 = new int[] {10,10,10,10,10,10,10,10,10,10};


        System.out.println(solution(2,10,truck_weights1));
        System.out.println(solution(100,100,truck_weights2));
        System.out.println(solution(100,100,truck_weights3));


    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur_weight = 0;
        ArrayDeque<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0); // 다리 길이만큼 0으로 채움
        }

        int index = 0;

        while (index < truck_weights.length) {
            // 시간 경과
            answer++;

            // 다리에서 트럭 하나 내리기
            cur_weight -= bridge.poll();

            // 다음 트럭이 다리에 올라갈 수 있는지 확인
            if (cur_weight + truck_weights[index] <= weight) {
                // 트럭 다리에 올리기
                bridge.offer(truck_weights[index]);
                cur_weight += truck_weights[index];
                index++;
            } else {
                // 트럭 다리에 올리지 못하면 0을 올려서 다리의 길이 유지
                bridge.offer(0);
            }
        }

        // 마지막 트럭이 다리를 다 건너기까지 걸리는 시간 추가
        answer += bridge_length;

        return answer;
    }

}
