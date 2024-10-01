package week_5.Jungjuhyeon;

import java.util.Arrays;

public class PGS_카펫 {

    public static int[] solution(int brown, int yellow) {
        int sum = brown+yellow;
        int a=0;
        int b=0;

        for(int i=3;i<sum;i++){
            int j = sum/i;
            if(i*j==sum &&i*2 + (j-2)*2 ==brown){
                a = i;
                b = j;
            }
        }
        int[] answer =new int[]{a,b};
        return answer;

    }

    public static void main(String[] args)throws Exception{
        System.out.println(Arrays.toString(solution(10,2)));
        System.out.println(Arrays.toString(solution(8,1)));
        System.out.println(Arrays.toString(solution(24,24)));

    }
}

//1. sum = brown+yellow를 합한다.
//2. nxm을해서 sum이 나오는 걸 찾는다.
//3. n*2 + (m-2)*2를 해서 sum이 나오면 그게 답이다.
