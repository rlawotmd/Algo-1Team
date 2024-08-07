package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_최소직사각형 {

    static int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

    public static void main(String[] args){
        int answer = solution(sizes);
        System.out.println(answer);
    }

    static int solution(int[][] sizes) {
        int answer = 0;

        int length = sizes.length;
        int [] inArr1 = new int [length];
        int [] inArr2 = new int [length];

        for(int i=0; i<length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int a = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = a;
            }
        }

        for(int i=0; i<length; i++){
            //System.out.println("가로:"+sizes[i][0]);
            inArr1[i] = sizes[i][0];
            //Arrays.sort(inArr1);
            //System.out.println(inArr1[i]);

            //System.out.println("세로:"+sizes[i][1]);
            inArr2[i] = sizes[i][1];
            //Arrays.sort(inArr2);
            //System.out.println(inArr2[i]);
        }
        Arrays.sort(inArr1);
        Arrays.sort(inArr2);

        int max1 = inArr1[length-1];
        int max2 = inArr2[length-1];

        // System.out.println(max1);
        // System.out.println(max2);

        answer = max1 * max2;

        return answer;
    }

}
