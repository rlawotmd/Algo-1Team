package week_11.rlawotmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PGS_순위 {
    static int solution(int n, int[][] results) {
        int answer = 0;

        boolean[] v;
        Stack<Integer> s;
        List<List<Integer>> win = new ArrayList<>();
        List<List<Integer>> lose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }

        for (int i = 0; i < results.length; i++) {
            win.get(results[i][0] - 1).add(results[i][1] - 1);
            lose.get(results[i][1] - 1).add(results[i][0] - 1);
        }

        for (int i = 0; i < n; i++) {
            int player = i;
            int winTo = 0;
            int loseTo = 0;

            s = new Stack<>();
            v = new boolean[n];
            s.push(player);
            v[player] = true;

            while (!s.isEmpty()) {
                int cur = s.pop();
                for (int j = 0; j < win.get(cur).size(); j++) {
                    if (v[win.get(cur).get(j)]) continue;
                    s.push(win.get(cur).get(j));
                    v[win.get(cur).get(j)] = true;
                    winTo++;
                }
            }

            s = new Stack<>();
            v = new boolean[n];
            s.push(player);
            v[player] = true;

            while (!s.isEmpty()) {
                int cur = s.pop();
                for (int j = 0; j < lose.get(cur).size(); j++) {
                    if (v[lose.get(cur).get(j)]) continue;
                    s.push(lose.get(cur).get(j));
                    v[lose.get(cur).get(j)] = true;
                    loseTo++;
                }
            }

            if (winTo + loseTo == n - 1) answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(5, results)); // 2
    }
}
