package week_6.rhdqngkwk90;

import java.util.*;

public class PGS_섬연결하기 {

    //입력
    static int n = 4;
    static int[][] costs = {
            {0, 1, 1},
            {0, 2, 2},
            {1, 2, 5},
            {1, 3, 1},
            {2, 3, 8}
    };

    //출력
    public static void main(String[] args){
        int answer = solution(n, costs);
        System.out.println(answer);
    }

    //프림 알고리즘을 사용하여 최소 신장 트리(MST) 찾는 방법 - PrimPqMain 템플릿 사용
    static int solution(int n, int[][] costs) {
        int answer = 0;

        // 그래프 -> 인접 리스트
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] c : costs) {
            g[c[0]].add(new int[]{c[1], c[2]});
            g[c[1]].add(new int[]{c[0], c[2]});
        }

        //Prim
        boolean[] v = new boolean[n];
        int[] w = new int[n];
        Arrays.fill(w, Integer.MAX_VALUE);
        for(int i=0; i<n; i++) w[i] = Integer.MAX_VALUE; //Arrays.fill(w, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));

        int cnt = 0;
        w[0] = 0;

        pq.offer(new int[] {0, w[0]});
        //System.out.println(Arrays.toString(w)); System.out.println();

        while (!pq.isEmpty()) {
            int[] vw = pq.poll();
            int minVertex = vw[0];
            int min = vw[1];

            if (v[minVertex]) continue;

            v[minVertex] = true;
            answer += min;

            if (cnt == n-1) break;

            for(int[] j : g[minVertex]) {
                if(!v[j[0]] && w[j[0]]>j[1]) {
                    w[j[0]]=j[1];
                    pq.offer(new int[] {j[0],w[j[0]]});
                }
            }

        }

        return answer;
    }



}
