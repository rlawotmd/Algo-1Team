package week_5.rlawotmd;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS_모의고사 {
    static int[] solution(int[] answers) {
        int[] answer;

        int[] m1 = new int[] {1, 2, 3, 4, 5};
        int[] m2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] m3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int s1 = 0; int s2 = 0; int s3 = 0; int max = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == m1[i % m1.length]) s1++;
            if (answers[i] == m2[i % m2.length]) s2++;
            if (answers[i] == m3[i % m3.length]) s3++;
        }
        max = Math.max(s1, s2);
        max = Math.max(max, s3);

        int[][] ans = new int[3][2];

        ans[0][0] = 1; ans[1][0] = 2; ans[2][0] = 3;
        ans[0][1] = s1; ans[1][1] = s2; ans[2][1] = s3;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (ans[i][1] == max) list.add(ans[i][0]);
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
//        int[] answers = new int[] {1, 2, 3, 4, 5};
        int[] answers = new int[] {1, 1, 2};
        System.out.println(Arrays.toString(solution(answers))); // 1

        answers = new int[] {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(answers))); // 1, 2, 3
    }
}
