package week_4.rlawotmd;

import java.util.Arrays;

public class PGS_K번째수 {
    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] a = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(a);
            answer[i] = a[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
