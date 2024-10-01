package week_5.rlawotmd;

import java.util.Arrays;

public class PGS_카펫 {
    static int[] solution(int brown, int yellow) {
        int[] answer = {};

        if (yellow == 1) return new int[] {3, 3};

        for (int i = 1; i <= yellow / 2; i++) {
            int y = i + 2;
            int x = yellow / i + 2;
            if (x * y == brown + yellow && 2 * x + 2 * y == brown + 4)
                return new int[] {x, y};
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown = 10; int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow))); // 4, 3

        brown = 8; yellow = 1;
        System.out.println(Arrays.toString(solution(brown, yellow))); // 3, 3

        brown = 24; yellow = 24;
        System.out.println(Arrays.toString(solution(brown, yellow))); // 8, 6
    }
}
