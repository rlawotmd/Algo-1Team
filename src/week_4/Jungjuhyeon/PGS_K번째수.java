package week_4.Jungjuhyeon;

import java.util.*;

public class PGS_K번째수 {

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i=0;
        for(int[] ar : commands){
            int start = ar[0];
            int end = ar[1];
            int k = ar[2];
            int[] newArr = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(newArr);
            answer[i++] = newArr[k-1];
        }
        return answer;
    }

    public static void main(String[] args)throws Exception{
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array,commands)));
    }
}
