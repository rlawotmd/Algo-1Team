package week_10.rlawotmd;

import java.util.Arrays;

public class PGS_입국심사 {
    static long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = 1;
        long end = (long) n * times[times.length - 1];
        long mid;
        long answer = end;


        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                answer = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] times = new int[]{7, 10};
        System.out.println(solution(6, times)); // 28
    }
}
