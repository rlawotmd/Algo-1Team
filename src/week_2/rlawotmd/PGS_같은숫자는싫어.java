package week_2.rlawotmd;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PGS_같은숫자는싫어 {
    static int[] solution(int[] arr) {
        int[] answer;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (q.peekLast() == arr[i]) continue;
            q.offer(arr[i]);
        }

        answer = new int[q.size()];
        int tc = q.size();

        for (int i = 0; i < tc; i++) {
            answer[i] = q.poll();
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
