package week_4.rlawotmd;

import java.util.Arrays;

public class PGS_HIndex {
    static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i <= citations.length; i++) {
            int bef = 0;
            int aft = citations.length;
            boolean found = true;
            for (int j = 0; j < citations.length; j++) {
                if (i >= citations[j]) {
                    bef++;
                    aft--;
                }
                if (i == citations[j]) {
                    aft++;
                }
                if (bef > i || aft < i) {
                    found = false;
                    break;
                }
            }
            if (found && answer < i) answer = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = new int[] {3, 0, 6, 1, 5};
        System.out.println(solution(citations));

        citations = new int[] {5, 6, 7, 8};
        System.out.println(solution(citations)); // 4
    }
}
