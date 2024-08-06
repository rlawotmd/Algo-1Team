package week_5.rlawotmd;

import java.util.ArrayDeque;

public class PGS_전력망을둘로나누기 {
    static boolean[] v;
    static int[][] arr;

    static void dfs(int tower) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(tower);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (v[cur]) continue;
            v[cur] = true;
            for (int i = 0; i < arr[cur].length; i++) {
                if (arr[cur][i] == 1) {
                    stack.push(i);
                }
            }
        }
    }

    static int count() {
        int count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i]) count++;
        }
        int rest = v.length - count;
        return Math.abs(count - rest);
    }

    static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            v = new boolean[n];
            arr = new int[n][n];
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int t1 = wires[j][0] - 1; int t2 = wires[j][1] - 1;
                arr[t1][t2] = 1;
                arr[t2][t1] = 1;
            }

            dfs(wires[i][0] - 1);
            answer = Math.min(answer, count());
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n, wires)); // 3

        n = 4;
        wires = new int[][] {{1,2},{2,3},{3,4}};
        System.out.println(solution(n, wires)); // 0

        n = 7;
        wires = new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        System.out.println(solution(n, wires)); // 1
    }
}
