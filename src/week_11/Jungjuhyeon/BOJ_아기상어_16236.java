package week_11.Jungjuhyeon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_아기상어_16236 {
    static int N;
    static int[][] a;

    //상좌우하
    static final int[] di = {-1,0,0,1}; //y
    static final int[] dj = {0,-1,1,0}; //x

    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        a = new int[N][N];
        int[] cur = null;


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] == 9 ){
                    cur = new int[]{i,j};
                    a[i][j] =0;
                }
            }
        }
        int size = 2; //아기상어 크기
        int eat =0; //먹이 먹은 수
        int move =0; //움직인 총거리

        while(true){
            PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));

            boolean[][] v = new boolean[N][N];

            q.add(new int[]{cur[0],cur[1],0});
            v[cur[0]][cur[1]] = true;

            boolean ck = false; // 상어가 먹이를 먹었는지 체크할 변수

            while(!q.isEmpty()){
                cur = q.poll();

                if (a[cur[0]][cur[1]] != 0 && a[cur[0]][cur[1]] < size) { // 먹이가 있으면서 상어의 사이즈보다 작다면?
                    a[cur[0]][cur[1]] = 0; // 물고기를 제거
                    eat++;
                    move += cur[2]; // 움직인 거리를 총 움직인 거리에 추가
                    ck = true; // 먹이 먹었다고 체크
                    break;
                }
                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + di[k];
                    int nx = cur[1] + dj[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || v[ny][nx] || a[ny][nx] > size)
                        continue;

                    q.add(new int[]{ny, nx, cur[2] + 1});
                    v[ny][nx] = true;
                }
            }

            if(!ck)
                break;// 큐가 비워질 때까지 먹이를 먹은적이 없다면


            if (size == eat) { // 사이즈와 먹이를 먹은 수가 동일하다면 상어의 크기를 증가
                size++;
                eat = 0;
            }
        }





        System.out.println(move);

    }


}



