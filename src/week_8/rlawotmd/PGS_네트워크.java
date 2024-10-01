package week_8.rlawotmd;

import java.util.Stack;

public class PGS_네트워크 {
    static boolean check(boolean[] v) {
        for (int i = 0; i < v.length; i++) if (!v[i]) return false;
        return true;
    }

    static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] v = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (v[i]) continue;
            answer++;
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1 && !v[j]) {
                    stack.push(j);
                    v[j] = true;
                }
            }

            while (!stack.isEmpty()) {
                int loc = stack.pop();
                for (int j = 0; j < n; j++) {
                    if (!v[j] && j != loc && computers[loc][j] == 1) {
                        stack.push(j);
                        v[j] = true;
                    }
                }
            }
            if (check(v)) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers)); // 2

        computers = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computers)); // 1
    }
}
