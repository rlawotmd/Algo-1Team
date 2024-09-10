package week_10.Jungjuhyeon;

import java.util.*;
public class PGS_입국심사 {
    public static long solution(int n, int[] times) {

        long answer = 0;

        Arrays.sort(times);

        long left = 0;

        //모든 사람이 젤 늦은 시간에 가서 받을 때,
        long right = times[times.length-1] * (long)n;

        while(left <= right) {
            long mid = (left + right) / 2;
            long complete = 0;
            for (int i = 0; i < times.length; i++)
                complete += mid / times[i];

            if (complete < n) // 해당 시간에는 모든 사람이 검사받을 수 없다.
                left = mid + 1;
            else {
                right = mid - 1;
                answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int n =6;
        int [] times = new int[]{7, 10};

        System.out.println(solution(n,times));

    }
}

