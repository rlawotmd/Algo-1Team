package week_5.Jungjuhyeon;

import java.util.Arrays;

public class PGS_소수찾기 {

    static String solution(int[] numbers) {
        int N = numbers.length;
        String answer ="";

        String[] str = new String[N];

        for(int i=0;i<N;i++){
            str[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str,(o1,o2)->(o2+o1).compareTo(o1+o2));

        if(str[0].equals("0")){
            return "0";
        }

        for(String s : str){
            answer+=s;
        }

        return answer;
    }

    public static void main(String[] args){
        int[] prices = new int[] {7,5,4,90,85};
        String s = solution(prices);
        System.out.println(s);

    }
}


/* 순열로 풀이
public static int N,C;
    public static boolean[] v;
    public static int[] b;
    public static int max = Integer.MIN_VALUE;

    public static void perm(int cnt,int[] numbers){
        if(cnt == N){
            String str ="";
            for(int i=0;i<N;i++)
            {
                str += Integer.toString(b[i]);
            }

            max = Math.max(max,Integer.parseInt(str));
        }
        for(int i=0;i<N;i++){
            if(v[i]) continue;
            v[i] =true;
            b[cnt] = numbers[i];
            perm(cnt+1,numbers);
            v[i] = false;
        }
    }

    public static String solution(int[] numbers) {
        N = numbers.length;
        v = new boolean[N];
        b = new int[N];
        perm(0,numbers);

        return Integer.toString(max);
    }
 */
