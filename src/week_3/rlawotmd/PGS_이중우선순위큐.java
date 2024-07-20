package week_3.rlawotmd;

import java.util.*;

public class PGS_이중우선순위큐 {
    static int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (s.equals("I")) {
                min.offer(n);
                max.offer(n);
            }
            if (s.equals("D")) {
                if (min.isEmpty() || max.isEmpty()) continue;
                if (n == -1) {
                    int m = min.poll();
                    if (max.contains(m)) max.remove(m);
                } else if (n == 1) {
                    int m = max.poll();
                    if (min.contains(m)) min.remove(m);
                }
            }
//            System.out.println("min : " + Arrays.toString(min.toArray()));
//            System.out.println("max : " + Arrays.toString(max.toArray()));
//            System.out.println("---");
        }
        if (max.isEmpty()) return answer;

        answer[0] = max.poll();
        answer[1] = min.poll();

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(operations))); // 0, 0

        operations = new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations))); // 333, -45
    }
}
