package week_6.rhdqngkwk90;

import java.util.*;

public class PGS_체육복 {

    //입력
    static int n = 5;
    static int[] lost = {2, 4};
    static int[] reserve = {1, 3, 5};

    //출력
    public static void main(String[] args){
        int answer = solution(n, lost, reserve);
        System.out.println(answer);
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++) {

            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]){
                    cnt++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }

        }

        for(int i=0; i<lost.length; i++) {

            for(int j=0; j<reserve.length; j++) {
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1){
                    cnt++;
                    reserve[j] = -1;
                    break;
                }
            }

        }

        answer = n - lost.length + cnt;
        return answer;
    }

}
