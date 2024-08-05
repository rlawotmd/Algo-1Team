package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_카펫 {

    //입력
    static int brown = 24, yellow= 24;

    public static void main(String[] args){
        int[] answer = solution(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //1. 총 카펫의 개수 N은 brown + yellow
        int N = brown + yellow;
        //2. 조건에 맞는 a, b 찾기
        for(int i=1; i<=N; i++){
            int a = i;
            int b = N / a;
            if(a >= b && N == a*b && (2*a + 2*b - 4) == brown){
                answer[0] = a;
                answer[1] = b;
                break;
            }
        }
        //(조건1) a * b = N 인 조합 중 a > b 인 것
        /*
          a> 4 b> 3
          a> 6 b> 2
          a> 12 b> 1
        */

        //(조건2) 2a + 2b - 4 = brown?
        /*
                      8
        ■ ■ ■ ■ ■ ■ ■ ■ 6
        ■ □ □ □ □ □ □ ■
        ■ □ □ □ □ □ □ ■
        ■ □ □ □ □ □ □ ■
        ■ □ □ □ □ □ □ ■
        ■ ■ ■ ■ ■ ■ ■ ■

        8+8+6+6 - 4 = 24?

                             12
        ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ 4
        ■ □ □ □ □ □ □ □ □ □ □ ■
        ■ □ □ □ □ □ □ □ □ □ □ ■
        ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■

        12+12+4+4 -4 = 24?
        */
        return answer;
    }


}
