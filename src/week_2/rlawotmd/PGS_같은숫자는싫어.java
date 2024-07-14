package week_2.rlawotmd;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PGS_같은숫자는싫어 {
    static int[] solution(int[] arr) {
        int[] answer;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(arr[0]); // 0번째 인덱스를 추가하고 시작

        for (int i = 1; i < arr.length; i++) { // 0번째 인덱스는 추가했기에 첫번째부터 시작
            if (q.peekLast() == arr[i]) continue; // 이미 들어간 숫자와 같을 경우 동작하지 않음
            q.offer(arr[i]); // 그 외에는 추가
        }

        answer = new int[q.size()];
        int tc = q.size();

        for (int i = 0; i < tc; i++) {
            answer[i] = q.poll(); // 반복문을 통해 Q에 있는 값들을 배열에 저장
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));

        arr = new int[] {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr)));

    }
}
