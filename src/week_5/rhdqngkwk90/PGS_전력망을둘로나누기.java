package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_전력망을둘로나누기 {

    //입력
    static int N = 9;
    static int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

    static int[][] graph;
    static boolean[] v;

    public static void main(String[] args){
        int answer = solution(N, wires);
        System.out.println(answer);
    }

    static int solution(int N, int[][] wires) {
        int answer = N;
        graph = new int[N+1][N+1];
        int E = wires.length;
        int from, to;

        //인접행렬에 input
        for(int i=0; i<E; i++) {
            from = wires[i][0];
            to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        //선을 하나씩 끊어보며 순회
        for(int i=0; i<E; i++) {
            from = wires[i][0];
            to = wires[i][1];

            //선을 하나 끊고
            graph[from][to] = 0;
            graph[to][from] = 0;

            //bfs
            answer = Math.min(answer, bfs(N, from));

            //선 다시 복구
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }//solution

    static int bfs(int N, int i){
        v = new boolean[N+1];
        int cnt = 1;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(i);

        while(!q.isEmpty()){
            i = q.poll();
            v[i] = true;

            for(int j=1; j<=N; j++){
                //if(v[j]) continue;
                if(graph[i][j] != 0 && !v[j]) {
                    v[i] = true;
                    q.offer(j);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(N-2*cnt);
    }//bfs

}
