package week_2.kyoul10121;

import java.util.*;

public class PGS_기능개발 {
    public static void main(String[] arg){
        int[] progresses = new int[] {93, 30, 55};
        int[] speeds = new int[] {1, 30, 5};

        System.out.println(solution(progresses,speeds));
    }
    public static ArrayList solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();   //progress의 각 인덱스 값이 100을 넘는 최소일 수를 담을 Queue queue 선언

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        //queue에 값이 없을 때까지 반복
        while (!queue.isEmpty()) {
            int days = queue.poll();    //queue에서 꺼낸 값을 days에 저장
            int count = 1;  //count -> 해당 일자에 배포되는 총 기능의 수를 담기 위한 변수

            //queue가 비어있지 않고 peek의 값이 days보다 작은 동안
            while (!queue.isEmpty() && queue.peek() <= days) {
                queue.poll();
                count++;
            }
            answer.add(count);  //count의 값을 answer배열에 추가
        }
        return answer;
    }
}
