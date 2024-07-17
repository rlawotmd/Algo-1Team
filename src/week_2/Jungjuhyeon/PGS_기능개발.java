package week_2.Jungjuhyeon;

import java.util.*;

public class PGS_기능개발 {
    public static void main(String[] args){
        int[] progresses1 = new int[] {93,30,55};
        int[] speeds1 = new int[] {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses1,speeds1)));

        int[] progresses2 = new int[] {95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[] {1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution(progresses2,speeds2)));

    }
    static int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<progresses.length;i++){
            q.offer(progresses[i]);
        }

        List<Integer> answerList = new ArrayList<>();
        int day = 0;
        int idx=0;

        while(!q.isEmpty()){
            int count =0;
            while (!q.isEmpty() && q.peek() + day * speeds[idx] >= 100) {
                q.poll();
                count++;
                idx++;
            }
            if(count>0){
                answerList.add(count);
            }
            day++;

        }
        int[] answer = new int[answerList.size()];

        for(int i=0;i<answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
