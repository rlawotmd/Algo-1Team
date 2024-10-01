package week_7.rlawotmd;

public class PGS_등굣길 {
    static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        for (int[] i : puddles) {
            map[i[1]][i[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            if (map[i][1] == -1) break;
            map[i][1] = 1;
        }

        for (int i = 1; i <= m; i++) {
            if (map[1][i] == -1) break;
            map[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) continue;
                if (map[i - 1][j] == -1 || map[i][j - 1] == -1) {
                    if (map[i - 1][j] == -1 && map[i][j - 1] != -1) map[i][j] = map[i][j - 1] % 1000000007;
                    if (map[i - 1][j] != -1 && map[i][j - 1] == -1) map[i][j] = map[i - 1][j] % 1000000007;
                    continue;
                }
                map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
            }
        }

        return map[n][m];
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{{2, 2}};
        System.out.println(solution(m, n, puddles));
    }
}
