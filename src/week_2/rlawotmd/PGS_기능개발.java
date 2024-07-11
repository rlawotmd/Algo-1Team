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
            q.offer(progresses[i]);
        }

        List<Integer> l = new ArrayList<>();
        int point = 0;

        while (!q.isEmpty()) {
            int cnt = 0;

            for (int i = point; i < progresses.length; i++) {
                q.offer(q.poll() + speeds[i]);
            }

             while (!q.isEmpty() && q.peek() >= 100) {
                 q.poll();
                 cnt++;
             }

            if (cnt > 0) {
                l.add(cnt);
                point += cnt;
            }
        }

        answer = l.stream().mapToInt(i -> i).toArray();

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

