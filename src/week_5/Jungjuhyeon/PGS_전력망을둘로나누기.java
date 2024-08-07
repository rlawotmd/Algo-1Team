package week_5.Jungjuhyeon;
import java.util.*;

public class PGS_전력망을둘로나누기 {

    public static int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n + 1];
        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 엣지 추가
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int minDifference = Integer.MAX_VALUE;

        // 각 엣지를 제거하고 결과를 확인
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 엣지 제거
            graph[a].remove((Integer)b);
            graph[b].remove((Integer)a);

            // DFS를 통해 하나의 컴포넌트의 크기 측정
            boolean[] visited = new boolean[n + 1];
            int componentSize = dfs(a, graph, visited);

            // 나머지 컴포넌트의 크기 계산
            int otherComponentSize = n - componentSize;

            // 차이 계산 및 최솟값 갱신
            minDifference = Math.min(minDifference, Math.abs(componentSize - otherComponentSize));

            // 엣지 복원
            graph[a].add(b);
            graph[b].add(a);
        }

        return minDifference;
    }

    // DFS 함수
    private static int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) return 0;

        visited[node] = true;
        int size = 1; // 현재 노드를 포함

        for (int neighbor : graph[node]) {
            size += dfs(neighbor, graph, visited);
        }

        return size;
    }

    public static void main(String[] args)throws Exception{
        System.out.println(solution(4,new int[][]{{1,2},{2,3},{3,4}}));

    }
}
