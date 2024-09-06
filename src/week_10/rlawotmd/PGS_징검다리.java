package week_10.rlawotmd;

import java.util.Arrays;

public class PGS_징검다리 {
    static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int start = 0;
        int end = distance;
        int mid;
        int loc;
        int cnt;

        while (start <= end) {
            mid = (start + end) / 2;
            loc = 0;
            cnt = 0;

            for (int rock : rocks) {
                if (rock - loc > mid) {
                    cnt++;
                    loc = rock;
                }
            }

            if (distance - loc > mid) cnt++;

            if (cnt >= rocks.length - n + 1) {
                start = mid + 1;
            }
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] rocks = new int[] {2, 14, 11, 21, 17};
        System.out.println(solution(25, rocks, 2)); // 4
    }
}
