package week_5.rhdqngkwk90;

import java.util.*;

public class ETC_완전탐색 {

    static int result1, result21, result22, result3;
    static String result4;

    //입력
    //1 브루트 포스
    static int[] password = {3,4,5};

    //2 재귀 호출
    static int num = 10;

    //3 순열 탐색
    static int N = 3, R = 2;
    static int[] a = {1,2,3}, b = new int[R];
    static boolean[] v = new boolean[N];

    //4 비 선형 구조 탐색
    static int Node = 8;
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    static boolean[] visited = new boolean[Node+1];

    //5 비트 마스크
    static int[] arr = {1,2,3};
    static int k = 2;
    static List<List<Integer>> list = new ArrayList<>();

    //출력
    public static void main(String[] args) {
        result1 = BruteForceEx(password);
        System.out.println("브루트 포스 예시 답 : "+result1);
        System.out.println();

        result21 = recursionEx1(num);
        System.out.println("재귀 호출 예시1 팩토리얼 답 : "+result21);
        result22 = recursionEx2(num);
        System.out.println("재귀 호출 예시2 피보나치 수열 답 : "+result22);
        System.out.println();

        result3 = 0;
        permEx(0);
        System.out.println("순열 탐색 예시 답 : "+result3);
        System.out.println();

        result4 = bfs(1, graph, visited);
        System.out.println("비선형 구조 BFS 답 :"+result4);
        System.out.println();

        visited = new boolean[Node+1];
        System.out.println("비선형 구조 DFS (재귀) 답");
        dfs1(1);
        System.out.println("\n");
        visited = new boolean[Node+1];
        System.out.println("비선형 구조 DFS (스택) 답");
        dfs2(1);
        System.out.println("\n");

        System.out.println("비트 마스크 답");
        list = bitmask(arr, k);
        System.out.println(list);
    }

    /* 1 브루트 포스 예시
   자물쇠의 비밀번호를 잊어버렸다면,
   000부터 999까지 하나씩 돌리는 방식으로 비밀번호를 구할 수 있다.
   비밀번호가 345라면, 몇번의 시도만에 자물쇠가 해제되는지 확인하는 문제
 */
    static int BruteForceEx(int[] password) {
        int cnt = 0;

        for(int i=0; i<=9; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=9; k++){

                    cnt++;
                    if(password[0] == i && password[1] == j && password[2] == k){
                        System.out.println("자물쇠 해제 !! ");
                        System.out.println("비밀번호는 " + i + j + k); //345
                        System.out.println("시도 횟수 " + cnt); //346 (000부터 카운트)
                        return cnt;
                    }

                }
            }
        }
        return cnt;
    }//BruteForceEx

    /* 2-1 재귀 호출 예시1 - 팩토리얼
       10 팩토리얼을 구하는 문제
     */
    static int recursionEx1(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * recursionEx1(num - 1);
        }
    }//recursionEx1

    /* 2-2 재귀 호출 예시1 - 피보나치 수열
       피보나치 수열의 10번째 숫자를 구하는 문제
    */
    static int recursionEx2(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            return recursionEx2(num - 1) + recursionEx2(num - 2);
        }
    }//recursionEx2

    /* 3 순열 탐색 예시
       주어진 크기가 N인 배열에 대해
       1부터 N까지의 수로 이루어진 순열을 사전순으로 출력,
       순열 개수를 확인하는 문제
     */
    static void permEx(int cnt) {
        //탈출구문
        if(cnt==R) {
            //System.out.println("탈출, b 배열 출력 : "+Arrays.toString(b));
            System.out.println(Arrays.toString(b));
            result3++;
            return;
        }
        //반복구문
        for(int i=0; i<N; i++) {
            //System.out.println("--- cnt가 R과 같지 않으면 반복 시작 ("+cnt+" == "+R+") ? ---");
            //System.out.println("반복 : "+i+" , v[i] true면 continue,  ("+v[i]+")");
            if(v[i]) continue;
            //System.out.println("반복 : "+i+" , v[i] false면  true로 고정, 다음 수 탐색 ("+v[i]+")");
            v[i] = true;
            //System.out.println("배열 b 안에 a[i] 넣기 : "+"b["+cnt+"] --> "+a[i]);
            b[cnt] = a[i];
            //System.out.println("(재귀호출)");
            permEx(cnt+1);
            v[i] = false;
        }
    }//permEx

    /* 4-1 비선형 구조 탐색 - BFS
    *  6 - 2 - 1 - 3 - 5
    *      |  /        | \
    *      8           4 - 7
    * 위와 같은 그래프를 1을 기준으로 너비 우선 탐색(BFS)하고 결과를 출력하는 문제
    */
    static String bfs(int start, int[][] graph, boolean[] visited) {
        // 탐색 순서를 출력하기 위한 용도
        StringBuilder sb = new StringBuilder();

        // BFS에 사용할 큐를 생성
        Queue<Integer> q = new LinkedList<Integer>();

        // 큐에 BFS를 시작 할 노드 번호를 넣기
        q.offer(start);

        // 시작노드 방문처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " -> ");

            //큐에서 꺼낸 노드와 연결된 노드들 체크
            for(int i=0; i<graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                // 방문하지 않았으면 방문처리 후 큐에 넣기
                if(!visited[temp]) { //나랑 인접, 방문한적 X
                    visited[temp] = true;
                    q.offer(temp);
                }
            }

        }
        // 탐색순서 리턴
        return sb.toString() ;
    }//bfs

    /* 4-2-1 비선형 구조 탐색 - DFS - (재귀)
     *  6 - 2 - 1 - 3 - 5
     *      |  /        | \
     *      8           4 - 7
     * 위와 같은 그래프를 1을 기준으로 깊이 우선 탐색(DFS)하고 결과를 출력하는 문제
     */
    static void dfs1(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 방문 노드 출력
        System.out.print(nodeIndex + " -> ");

        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if(!visited[node]) {
                dfs1(node);
            }
        }
    }//dfs1

    /* 4-2-2 비선형 구조 탐색 - DFS - (스택)
     *  6 - 2 - 1 - 3 - 5
     *      |  /        | \
     *      8           4 - 7
     * 위와 같은 그래프를 1을 기준으로 깊이 우선 탐색(DFS)하고 결과를 출력하는 문제
     */
    static void dfs2(int start) {
        //스택
        Stack<Integer> stack = new Stack<>();

        //시작 노드를 스택에 넣기
        stack.push(start);

        // 방문 처리
        visited[start] = true;

        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {

            // 스택에서 하나를 꺼냅니다.
            int nodeIndex = stack.pop();

            //방문 노드 출력
            System.out.print(nodeIndex + " -> ");

            // 꺼낸 노드와 인접한 노드 찾기
            for (int LinkedNode : graph[nodeIndex]) {
                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
                if(!visited[LinkedNode]) {
                    stack.push(LinkedNode);
                    visited[LinkedNode] = true;
                }
            }
        }
    }//dfs2

    /* 5 비트 마스크 - 조합 구현
     * 비트 연산자를 사용하여 조합을 구하는 문제
     * {1,2,3} 에서 2개 뽑는 조합 출력하기
     */
    static List<List<Integer>> bitmask(int[] arr, int k){
        List<List<Integer>> list = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<1<<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if((i & 1<<j)>0) cnt++;
            }
            if(cnt==k){
                List<Integer> tmp = new ArrayList<>();
                for(int j=0;j<n;j++){
                    if((i & 1<<j) > 0){
                        tmp.add(arr[j]);
                    }
                }
                list.add(tmp);
            }
        }
        return list;
    }//bitmask

}
