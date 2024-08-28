package week_8.rhdqngkwk90;

import java.util.*;

public class PGS_게임맵최단거리 {

    //입력
    static int[][] maps = {{1, 0, 1, 1, 1}
                         , {1, 0, 1, 0, 1}
                         , {1, 0, 1, 1, 1}
                         , {1, 1, 1, 0, 1}
                         , {0, 0, 0, 0, 1}};

    //출력
    public static void main(String[] args){
        int answer = solution(maps);
        System.out.println(answer);
    }

    //방향 : 		   상  우  하  좌
    static int[] di = { -1, 0, 1, 0 };
    static int[] dj = {  0, 1, 0, -1 };

    static int n, m;
    static boolean[][] visit;
    static int answer = -1;

    static int solution(int[][] maps) {

        //맵 크기 확인
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];

        bfs(maps);

        return answer;
    }

    static void bfs(int[][] maps) { //시작 정점 start

        //현재위치 x좌표[0], y좌표[1], 이동거리[2] 를 확인하기 위해 int[]으로 넣는다.
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {0, 0, 1}); //시작 위치와 이동 거리를 int 배열에 넣는다.
        visit[0][0] = true; //시작 위치 방문처리

        while(!queue.isEmpty()) {

            //현재 위치와 이동거리 꺼내기
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            //System.out.println("현재 위치 : "+Arrays.toString(current)+" 현재까지 이동거리 : "+distance);

            //도착했으면 이동거리 반환하기
            if (x == n-1 && y == m-1) {
                //System.out.print("이동거리 리턴 : "+distance+" ");
                answer = distance;
                break;
            }

            for(int i=0; i<4; i++) { //상우하좌 탐색

                //이동 가능한 다음 위치 확인
                int nextX = x + di[i];
                int nextY = y + dj[i];

                /* 1. 다음으로 이동할 위치가 map 범위 안에 존재하는지
                 * 2. 나랑 인접한 곳이 벽(0)이 아닌지
                 * 3. 방문한적이 없는 곳인지
                 */
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m
                        && maps[nextX][nextY] != 0
                        && !visit[nextX][nextY]) {

                    visit[nextX][nextY] = true; //다음 위치 방문처리
                    queue.offer(new int[] {nextX, nextY, distance+1}); //다음 위치 큐에 넣어주기
                }

            }

        }

    }
}
