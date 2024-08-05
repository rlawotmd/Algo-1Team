package week_5.rhdqngkwk90;

import java.util.*;

public class PGS_모의고사 {

    static int[] answers = {1, 3, 2, 4, 2};

    public static void main(String[] args){
        int[] answer = solution(answers);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a1 = 0, a2 = 0, a3 = 0;
        for(int i=0; i<answers.length; i++){
            if(p1[i%5] == answers[i]){a1++;}
            if(p2[i%8] == answers[i]){a2++;}
            if(p3[i%10] == answers[i]){a3++;}
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = Math.max(Math.max(a1, a2),a3);
        if(a1 == max){list.add(1);}
        if(a2 == max){list.add(2);}
        if(a3 == max){list.add(3);}
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

}
