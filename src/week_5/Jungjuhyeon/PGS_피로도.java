package week_5.Jungjuhyeon;

import java.util.Arrays;

public class PGS_피로도 {

    static int answer = 0;
    static boolean[] v;

    public static int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public static void dfs(int cnt, int fatigue, int[][] dg) {
        for(int i = 0; i < dg.length; i++){
            if(v[i] || dg[i][0] > fatigue) continue;
            v[i] = true;
            dfs(cnt+1, fatigue-dg[i][1], dg);
            v[i] = false;
        }
        answer = Math.max(cnt, answer);
    }

    public static void main(String[] args)throws Exception{
        System.out.println(solution(80,new int[][]{{80,20},{50,40},{30,10}}));

    }
}
