package week_11.rlawotmd;

import java.util.*;

public class PGS_가장먼노드 {
    static int solution(int n, int[][] edge) {
        int answer = 0;

        // 2차원 배열로 하면 최대 크기 1.6 기가
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        boolean[] v = new boolean[n + 1];

        for (int[] arr : edge) {
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int node = q.poll();
                for (int k = 0; k < map.get(node).size(); k++) {
                    if (v[map.get(node).get(k)]) continue;
                    v[map.get(node).get(k)] = true;
                    q.add(map.get(node).get(k));
                }
            }
            if (q.isEmpty()) break;
            answer = q.size();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, edge)); // 3
    }
}
