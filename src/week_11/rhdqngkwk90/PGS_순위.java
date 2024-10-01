package week_11.rhdqngkwk90;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGS_순위 {

    //입력
    static int n = 5;
    static int[][] results = {
            {4, 3},
            {4, 2},
            {3, 2},
            {1, 2},
            {2, 5}};
    /*
      <그래프 모양>
      4 > 3 > 2 > 5
          1 > 2 > 5
      간선의 가중치를 1로 두고 구한다.

      → 플로이드-워셜 알고리즘
      : 다이나믹 프로그래밍 기법을 사용한 알고리즘의 한 종류로,
        (b > a) && (a > c) 이면 (b > c)이다.
        다익스트라 알고리즘과의 차이는
        - 음의 가중치를 갖는 간선이 존재할 수 있다는 것
        - 모든 노드에서 출발하여 모든 노드로 가는 각각의 최소 비용을 단계적으로 갱신하며 구해주는 알고리즘이다.

      → BFS로 풀 수 있다. (백준 2458)
    */

    static List<Integer>[] g;
    static Node[] d;

    //출력
    public static void main(String[] args) {
        int answer = solution(n, results);
        System.out.println(answer);
    }

    static int solution(int n, int[][] results) {
        int answer = 0;
        int cnt = 0;

        // 선언, 초기화
        g = new ArrayList[n + 1];
        d = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
            d[i] = new Node();
        }

        // 그래프 연결 상태(승패여부) List에 넣기 (인접리스트)
        for (int i = 0; i < results.length; i++) {
            int front = results[i][0];
            int back = results[i][1];
            g[front].add(back); // 단방향
        }

        bfs();

        // 노드 기준 이긴사람+진사람 = 전체-1 이면 순위를 확실히 알 수 있다.
        for (Node node : d) {
            if (node.front + node.back == n - 1) answer++;
        }

        return answer;
    }

    private static void bfs() {

        for (int i = 1; i < n + 1; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] v = new boolean[n + 1]; // 각 노드별 방문확인 하기때문에 여기서 초기화한다.

            v[i] = true;
            q.offer(i);

            while (!q.isEmpty()) {
                int winner = q.poll();

                for (int loser : g[winner]) {
                    if (v[loser]) continue;
                    v[loser] = true;
                    q.offer(loser);
                    d[i].front++;
                    d[loser].back++;
                }
                
            }
        }

    } // bfs

    private static class Node {
        int front; // 이긴 노드
        int back; // 진 노드
    } // Node

}
