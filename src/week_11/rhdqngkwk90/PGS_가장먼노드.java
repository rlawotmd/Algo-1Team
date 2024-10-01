package week_11.rhdqngkwk90;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PGS_가장먼노드 {

    //입력
    static int n = 6;
    static int[][] edge = {
            {3, 6},
            {4, 3},
            {3, 2},
            {1, 3},
            {1, 2},
            {2, 4},
            {5, 2}};
    /*
    <그래프 모양>
      1 ㅡ 2 ㅡ 5
      | /  |
      3 ㅡ 4
      |
      6

      1을 기준으로 각 노드로 향하는 최단 거리를 리스트에 저장하고 출력

      → 다익스트라 최단 경로
      : 그리디 알고리즘의 한 종류로,
        특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘이다.
    */

    static ArrayList<Integer>[] g;
    static int[] d;
    static boolean[] v;

    //출력
    public static void main(String[] args) {
        int answer = solution(n, edge);
        System.out.println(answer);
    }

    static int solution(int n, int[][] edge) {
        int answer = 0;

        // 선언, 초기화
        g = new ArrayList[n + 1];
        d = new int[n + 1]; // 1로부터 다른 노드까지의 최단 거리
        v = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE; // 최댓값으로 초기화
        }

        // 그래프 연결 상태 List에 넣기 (인접리스트)
        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            g[start].add(end);
            g[end].add(start); // 양방향 연결
        }
//        for (int i = 0; i < edge.length; i++) System.out.println(i + " : " + "인접리스트 상태 : " + g[i]);

        dijkstra(1);

        /*
         1 기준 최단거리 : 1, 0
         1 기준 최단거리 : 3, 1
         1 기준 최단거리 : 2, 1
         1 기준 최단거리 : 4, 2
         1 기준 최단거리 : 5, 2
         1 기준 최단거리 : 6, 2
        */
        //최단 거리 중 가장 먼 거리를 구하기
        int maxNum = 0;
        for (int i = 2; i < n + 1; i++) {
            maxNum = Math.max(maxNum, d[i]); // maxNum: 가장 먼 거리
        }

        //구한 가장 먼 거리에 해당하는 노드 개수 세기
        for (int i = 2; i < n + 1; i++) {
            if (maxNum == d[i]) answer++;
        }

        return answer;
    } // solution

    /* g
     0 : 인접리스트 상태 : []
     1 : 인접리스트 상태 : [3, 2]
     2 : 인접리스트 상태 : [3, 1, 4, 5]
     3 : 인접리스트 상태 : [6, 4, 2, 1]
     4 : 인접리스트 상태 : [3, 2]
     5 : 인접리스트 상태 : [2]
     6 : 인접리스트 상태 : [3]
     */
    // 다익스트라로 start로부터 다른 노드까지 최단 거리 구하기
    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐
        pq.offer(new Node(start, 0)); // 시작 위치, 거리 넣기
        d[start] = 0; // 나와의 거리는 0

        while (!pq.isEmpty()) {
            // 현재 위치와 이동거리 꺼내기
            Node value = pq.poll(); // 가장 가까운 거리를 가진 노드가 poll된다.

            // 아직 최단 거리 못 구했고, value를 경유해서 start로 가는게 더 빠르다면
            if (!v[value.index]) {
                for (int node : g[value.index]) {
                    if (!v[node] && d[node] > d[value.index] + 1) {
                        d[node] = d[value.index] + 1; // 그 값으로 갱신
                        pq.offer(new Node(node, d[node])); // 값 pq에 추가
                    }
                }
            }

        }
    } // dijkstra

    //노드 번호와 최단 거리를 저장하는 Node를 만든다. int[]이나 List로 처리해도 된다.
    private static class Node implements Comparable<Node> {
        int index; // 노드 번호
        int distance; // 거리

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node o) { // 거리 기준 오름차순
            return this.distance - o.distance;
        }
    } // Node


}
