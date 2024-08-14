package week_6.rlawotmd;

import java.util.Arrays;
import java.util.Stack;

public class PGS_섬연결하기 {
    static boolean[] visited;
    static boolean check(boolean[] v) {
        for (boolean b : v) {
            if (!b) return false;
        }
        return true;
    }

    static boolean[] dfs(int[][] arr, int start) {
        boolean[] v =  new boolean[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while (!s.isEmpty()) {
            int i = s.pop();
            v[i] = true;
            for (int j = 0; j < arr.length; j++) {
                if (v[j]) continue;
                if (arr[i][j] == 1) {
                    s.push(j);
                }
            }
        }
        visited = v.clone();
        return v;
    }

    static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] arr = new int[n][n];
        visited = new boolean[n];
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < costs.length; i++) {
            if (arr[costs[i][0]][costs[i][1]] == 1 && arr[costs[i][1]][costs[i][0]] == 1) continue;
            if (visited[costs[i][0]] && visited[costs[i][1]]) continue;
            arr[costs[i][0]][costs[i][1]] = 1;
            arr[costs[i][1]][costs[i][0]] = 1;
            answer += costs[i][2];
            if (check(dfs(arr, costs[i][0]))) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4, costs));

        costs = new int[][] {{0,1,1},{2,3,1},{3,1,3},{4,0,5},{4,2,4}};
        System.out.println(solution(5, costs));

        costs = new int[][] {{0,1,1},{2,3,1},{1,2,4}};
        System.out.println(solution(4, costs));
    }
}
