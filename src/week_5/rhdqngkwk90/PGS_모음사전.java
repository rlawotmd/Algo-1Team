package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_모음사전 {

    //입력
    static String word = "EIO";

    static String[] arr = {"A","E","I","O","U"};
    static int N = 5;
    static List<String> list;

    public static void main(String[] args){
        int answer = solution(word);
        System.out.println(answer);
    }

    static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        //전체 문자열 조합을 만들어줌
        comb(0, "");
        //정렬
        Collections.sort(list);
        //word의 순서를 구하기 (사전순이라 0번째는 없음 +1 해주기)
        answer = list.indexOf(word)+1;

        return answer;
    }

    //글자 조합
    static void comb(int cnt, String str) {
        //탈출
        if(cnt >= N) return;
        //반복
        for(int i=0; i<N; i++){
            //System.out.println("str>>"+str+" arr[i]>>"+arr[i]);
            list.add(str+arr[i]);
            comb(cnt+1, str+arr[i]);
        }
    }


}
