package week_8.rlawotmd;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_게임맵최단거리 {
    static int solution(int[][] maps) {
        int[] cx = {0, 1, 0, -1};
        int[] cy = {-1, 0, 1, 0};

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        v[0][0] = true;
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            if (loc[0] == n - 1 && loc[1] == m - 1) {return ans[loc[0]][loc[1]] + 1;}
            for (int k = 0; k < 4; k++) {
                int nx = loc[0] + cx[k];
                int ny = loc[1] + cy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (v[nx][ny]) continue;
                ans[nx][ny] = ans[loc[0]][loc[1]] + 1;
                q.add(new int[]{nx, ny});
                v[nx][ny] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] maps = new int[][] {
                {1, 0, 1, 1, 1}
                , {1, 0, 1, 0, 1}
                , {1, 0, 1, 1, 1}
                , {1, 1, 1, 0, 1}
                , {0, 0, 0, 0, 1}
        };
        System.out.println(solution(maps)); // 11

        maps = new int[][] {
                {1, 0, 1, 1, 1}
                , {1, 0, 1, 0, 1}
                , {1, 0, 1, 1, 1}
                , {1, 1, 1, 0, 0}
                , {0, 0, 0, 0, 1}
        };
        System.out.println(solution(maps)); // -1
    }
}
