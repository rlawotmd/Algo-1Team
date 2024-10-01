package week_4.Jungjuhyeon;

import java.util.Arrays;

public class PGS_HIndex {

    static int solution(int[] citations) {
        int max =0;
        int min =0;
        int answer =0;

        int length = citations.length;

        for(int i=1;i<=length;i++){
            for(int j=0;j<length;j++){
                int n = citations[j];
                if(n<=i){
                    min++;
                }
                if(n>=i){
                    max++;
                }
            }
            if(min<=i && max>=i){
                answer =i;
            }
            min = 0;
            max = 0;
        }
        return answer;
    }

    public static void main(String[] args)throws Exception{
        int[] citations = {3, 0, 6, 1, 5};
        int answer = solution(citations);
        System.out.println(answer);
    }
}
