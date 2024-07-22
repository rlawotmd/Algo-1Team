package week_3.rlawotmd;

import java.util.PriorityQueue;

public class PGS_디스크컨트롤러 {
    static int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        PriorityQueue<int[]> pos = new PriorityQueue<>((o1, o2) ->
                o1[1] == o2[1] ? o2[0] - o1[0] : o1[1] - o2[1]);

        for (int[] a : jobs) {
            pq.offer(a);
        }

//        System.out.print("Full PQ : ");
//        for (int[] i : pq) System.out.print("{" + i[0] + ", " + i[1] + "} ");
//        System.out.println();

        int sum = 0;
        int time = 0;

        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                pos.offer(pq.poll());
            }

//            System.out.print("Pos : ");
//            for (int[] i : pos) System.out.print("{" + i[0] + ", " + i[1] + "} ");
//            System.out.println();

            if (!pos.isEmpty()) {
                int[] a = pos.poll();
                time += a[1];
                sum += time- a[0];
            } else {
                int[] b = pq.poll();
                time = b[0] + b[1];
                sum += time - b[0];
            }
            while (!pos.isEmpty()) pq.offer(pos.poll());
        }

        return sum / jobs.length;
    }

    public static void main(String[] args) {
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
//        System.out.println("ans : " + solution(jobs)); // 9

        jobs = new int[][]{{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}};
        System.out.println("ans : " + solution(jobs)); // 11

        jobs = new int[][]{{0, 1}, {2, 2}, {2, 3}};
//        System.out.println("ans : " + solution(jobs)); //2

        jobs = new int[][]{{0, 3}, {4, 4}, {5, 3}, {7, 1}};
//        System.out.println("ans : " + solution(jobs)); // 4

        jobs = new int[][]{{7, 8}, {3, 5}, {9, 6}};
        System.out.println("ans : " + solution(jobs)); // 9

        jobs = new int[][]{{0, 3}, {10, 1}};
        System.out.println("ans : " + solution(jobs)); // 2

        jobs = new int[][]{{1, 4}, {7, 9}, {1000, 3}};
        System.out.println("ans : " + solution(jobs)); // 5
    }
}
