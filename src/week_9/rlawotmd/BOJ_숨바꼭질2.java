package week_9.rlawotmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_숨바꼭질2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[100001];

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int time = -1;
        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        v[n] = true;

        while (cnt == 0) {
            time += 1;
            int size = q.size();
            int loc;
            for (int i = 0; i < size; i++) {
                loc = q.remove();
                if (loc > 100000) continue;
                if (loc == k) {
                    cnt++;
                    continue;
                }
                v[loc] = true;
                if (loc == 0) {
                    if (!v[loc + 1]) q.add(loc + 1);
                } else if (loc > k) {
                    if (!v[loc - 1]) q.add(loc - 1);
                } else {
                    if (loc + 1 <= 100000 && !v[loc + 1]) q.add(loc + 1);
                    if (!v[loc - 1]) q.add(loc - 1);
                    if (loc * 2 <= 100000 && !v[loc * 2]) q.add(loc * 2);
                }
            }
        }

        System.out.println(time + "\n" + cnt);
    }
}

