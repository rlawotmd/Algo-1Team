package week_2.Jungjuhyeon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_주식가격 {
    public static void main(String[] args){
        int[] prices = new int[] {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));

    }
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i<prices.length-1;i++){
            int count =0;
            for(int j= i+1;j<prices.length;j++){
                count++;
                if(prices[i]>prices[j]){
                    break;
                }
            }
            answer[i] = count;
        }
        answer[prices.length-1] =0;

        return answer;
    }
}
