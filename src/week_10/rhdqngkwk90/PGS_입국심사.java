package week_10.rhdqngkwk90;

import java.util.Arrays;

public class PGS_입국심사 {

    //입력
    static int n = 6;
    static int[] times = {7, 10};
 
    //출력
    public static void main(String[] args) {
        long answer = solution(n, times);
        System.out.println(answer);
    }

    /*
     * 사실 처음에는 이게 왜 이분탐색? 탐색 범위인 심사대의 개수가 있어야 하는 것 아닌가 싶었다.
     * 근데 다시 생각해보니 기존에 범위가 먼저 주어져 있고 key를 찾는 방식이 아닌
     * "n명 심사 완료" 를 key로 두고, 심사 시간의 범위를 탐색 범위로 둔다면,
     * start를 최소시간, end를 최대시간으로 잡고, n명을 심사할 수 있는 최소 값을 구하면 된다.
     * 최소/최대 범위를 계속 줄여가며 mid을 갱신하고, n명이 모두 완료될 경우 그때의 mid가 최소값이 된다.
     */
    static long solution(int n, int[] times) {

        long answer = 0;

        Arrays.sort(times); //정렬

        //범위 설정
        long start = 1;
        long end = (long) times[times.length - 1] * n; //모든 사람이 가장 오래 걸리는 심사대에서 심사를 받는 경우

        answer = end;

        //start가 end보다 작거나 같을 때 까지 반복.
        while (start <= end) {

            long sum = 0;
            long mid = start + (end - start) / 2;

            //심사 완료 인원을 카운트
            for (int time : times) {
                sum += mid / time;
            }

            //시작, 종료 위치 변경
            if (sum >= n) { //arr[mid] > key
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return answer;
    }

}
