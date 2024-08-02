package week_4.rhdqngkwk90;

import java.util.*;

public class PGS_K번째수 {

    //입력
    static int[] array = {1, 5, 2, 6, 3, 7, 4};
    static int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

    //출력
    public static void main(String[] args) {
        int[] answer = solution(array, commands);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];

        for(int i=0; i<length; i++){
            int[] copy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(copy);
            answer[i] = copy[commands[i][2]-1];
        }
        return answer;
    }

}
