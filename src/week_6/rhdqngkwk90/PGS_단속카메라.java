package week_6.rhdqngkwk90;

import java.util.*;

public class PGS_단속카메라 {

    //입력
    static int[][] routes = {
            {-20, -15},
            {-14, -5},
            {-18, -13},
            {-5, -3}
    };

    //출력
    public static void main(String[] args){
        int answer = solution(routes);
        System.out.println(answer);
    }

    static int solution(int[][] routes) {
        int answer = 0;

        //겹치는 부분 구하는 문제
        /*  첫 번째 시도) 시작 위치랑 길이 값을 Map에 넣기 (차량의 진입 지점이 중복되지 않는다는 조건)
                        -> 의미없음
            두 번째 시도) 배열 돌면서 반복으로 구간 검사하기
                        -> 기준 잘 잡으면 쉽다.
        */
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        //for (int[] row : routes) {System.out.print(Arrays.toString(row)); System.out.println();

        int lastCameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            System.out.println(lastCameraPosition+"<"+route[0]+" "+answer);

            if (lastCameraPosition < route[0]) { // 차량의 진출 지점이 현재 카메라의 위치 범위에 포함되지 않는다면
                answer++;
                lastCameraPosition = route[1];
            }
        }
        /*  -2147483648 < -20 0
            -15 < -18 1 (증가)
            -15 < -14 1
            -5 < -5 2 (증가)
         */
        return answer;
    }


}
