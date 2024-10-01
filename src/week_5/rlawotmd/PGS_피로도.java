package week_5.rlawotmd;

public class PGS_피로도 {
    static int[] perm_arr;
    static int[] perm;
    static boolean[] v;
    static int eng;
    static int answer;

    static int check(int[][] dungeons) {
        int k = eng;
        int cnt = 0;

        for (int i = 0; i < perm_arr.length; i++) {
            if (k >= dungeons[perm[i]][0] && k >= dungeons[perm[i]][1]) {
                cnt++;
                k -= dungeons[perm[i]][1];
            }
        }
        return cnt;
    }

    static void Perm(int cnt, int[][] dungeons) {
        if (cnt == perm_arr.length) {
            answer = Math.max(check(dungeons), answer);
            return;
        }
        for (int i = 0; i < perm_arr.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            perm[cnt] = perm_arr[i];
            Perm(cnt + 1, dungeons);
            v[i] = false;
        }
    }

    static int solution(int k, int[][] dungeons) {
        answer = -1;
        eng = k;

        perm = new int[dungeons.length];
        perm_arr = new int[dungeons.length];
        v = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            perm_arr[i] = i;
        }

        Perm(0, dungeons);

        return answer;
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = new int[][] {{80, 20}, {50, 40}, {30, 10}};
        System.out.println(solution(k, dungeons)); // 3
    }
}
