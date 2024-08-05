package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_피로도 {

    //입력
    static int k = 	80;
    static int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

    static int kNum, N, C = 0;
    static int[] a, b;
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args){
        int answer = solution(k, dungeons);
        System.out.println(answer);
    }

    static int solution(int k, int[][] dungeons) {
        int answer = -1;
        /* 문제 요약
           피로도 -> 던전 탐험
           최소 필요 피로도 80
           던전 탐험 시 소모되는 소모 피로도 20
           던전 탐험을 위해선 80이상, 던전 탐험 후에는 20이 차감됨
           하루 여러개 던전 탐험, 던전은 하루에 한 번만 탐험 가능
           던전을 최대로 돌려면 어떤 조합으로 돌아야 하는가?
        */

        //1. k가 dungeons[0] 이상?
        //2. k = k - dungeons[1], cnt++
        //3. 반복
        //위의 3단계를 조합으로 경우의 수 따지기 - 순열

        //
        int length = dungeons.length;
        a = new int[length];
        int i=0;
        for(int[] d : dungeons){
            map.put(d[0], d[1]);
            a[i] = d[0];
            i++;
        }

        N = length;
        b = new int[N];
        v = new boolean[N];
        C = 0;
        perm(k, 0);
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0);

        return answer;
    }

    static void perm(int k, int cnt) {
        //탈출구문
        if(cnt==N) {
            kNum = k;
            int result = calc(b);
            list.add(result);
            C++;
            return;
        }
        //반복구문
        for(int i=0; i<N; i++) {
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(k, cnt+1);
            v[i] = false;
        }
    }

    static int calc(int[] b) {
        int result = 0;
        for(int key : b){
            if(kNum<key) break;
            kNum -= map.get(key);
            result++;
        }
        return result;
    }


}
