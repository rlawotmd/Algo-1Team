package week_3.rlawotmd;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.offer(new int[] {num, Math.abs(num)});
            } else {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else {
                    bw.write(pq.poll()[0] + "\n");
                }
            }
        }

        bw.flush();
    }
}
