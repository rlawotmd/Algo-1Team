package week_9.rhdqngkwk90;

import java.util.*;

public class PGS_단어변환 {

    //입력
    static String begin = "hit";
    static String target = "cog";
    static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

    static int N, M;
    static boolean[] visit;
    static int answer = 0;

    //출력
    public static void main(String[] args){
        N = words.length;
        M = begin.length();
        visit = new boolean[N];

        dfs(begin,0); //일치하는 단어까지 반복해서 확인하는거라 dfs 사용
        System.out.println(answer);
    }

    static int solution(String begin, String target, String[] words) {

        N = words.length;
        M = begin.length();
        visit = new boolean[N];

        dfs(begin,0); //일치하는 단어까지 반복해서 확인하는거라 dfs 사용
        return answer;
    }

    static void dfs(String begin, int cnt) { //시작 정점 cnt ~증가

        //System.out.println("(현재 단어) begin : "+begin+" target : "+target+" cnt : "+cnt);

        //같은 단어면 바로 반환
        if (begin.equals(target)) {
            answer = cnt;
            //System.out.println("변환 : "+answer);
            return;
        }

        //배열 내부 모든 단어와 비교
        for(int i=0; i<N; i++) {

            //이미 변환한건 비교X
            if (visit[i]) continue;

            //(문자열-배열내부단어) 같은 스펠링 개수 확인
            int k=0;
            for (int j=0; j<M; j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            /*
             * 한 번에 한 개의 알파벳만 바꿀 수 있습니다. = 한글자 빼고 모두 같으면 된다.
             */
            //한글자 빼고 모두 같은 경우
            if (k == M-1) {
                visit[i] = true; //변환처리
                dfs(words[i],cnt+1);
                visit[i] = false;
            }

        }

    }
}
