package week_4.rhdqngkwk90;

import java.util.*;

public class PGS_가장큰수 {

    //입력
    static int[] citations = {3, 0, 6, 1, 5};

    //출력
    public static void main(String[] args) {
        int answer = solution(citations);
        System.out.println(answer);
    }

    static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            int cnt = citations.length - i;
            if(cnt <= citations[i]){
                answer = cnt;
                break;
            }
        }

        return answer;
    }

}
