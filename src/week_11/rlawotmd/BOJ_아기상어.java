package week_11.rlawotmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_아기상어 {
    static int[] yi = {-1, 0, 0, 1};
    static int[] xj = {0, -1, 1, 0};

    static int sharkSize = 2;
    static int eatCount = 0;
    static int distance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int loc_yi = 0;
        int loc_xj = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    loc_yi = i;
                    loc_xj = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][n];
        int[][] length = new int[n][n];
        q.add(new int[]{loc_yi, loc_xj});
        v[loc_yi][loc_xj] = true;
        arr[loc_yi][loc_xj] = 0;

        while (!q.isEmpty()) {
            int minI = n;
            int minJ = n;
            int minDistance = Integer.MAX_VALUE;
            while (!q.isEmpty()) {
                int[] curArr = q.remove();
                for (int i = 0; i < 4; i++) {
                    int ci = curArr[0] + yi[i];
                    int cj = curArr[1] + xj[i];
                    if (ci < 0 || ci >= n || cj < 0 || cj >= n) continue;
                    if (v[ci][cj]) continue;
                    if (arr[ci][cj] > sharkSize) {
                        v[ci][cj] = true;
                        continue;
                    }
                    if (arr[ci][cj] == sharkSize || arr[ci][cj] == 0) {
                        v[ci][cj] = true;
                        length[ci][cj] = length[curArr[0]][curArr[1]] + 1;
                        q.add(new int[]{ci, cj});
                        continue;
                    }
                    if (minDistance < length[curArr[0]][curArr[1]] + 1) continue;
                    minDistance = length[curArr[0]][curArr[1]] + 1;
                    if (minI > ci || (minI == ci && minJ > cj)) {
                        minI = ci;
                        minJ = cj;
                    }
                    v[ci][cj] = true;
                    length[ci][cj] = length[curArr[0]][curArr[1]] + 1;
                }
            }
            if (minI >= n || minJ >= n) break;
            q.add(new int[]{minI, minJ});
            arr[minI][minJ] = 0;
            v = new boolean[n][n];
            v[minI][minJ] = true;

            distance += minDistance;
            length = new int[n][n];
            length[minI][minJ] = 0;
            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(distance);

    }
}
/*
6
1 6 6 6 6 6
0 6 0 0 0 1
0 6 0 6 6 6
0 0 9 6 6 6
6 6 6 6 6 6
6 6 6 6 6 6
답은 나오지만 조건대로라면 첫번째 줄에 있는 고기를 먹고 두번째 줄 고기를 먹어야함
 */