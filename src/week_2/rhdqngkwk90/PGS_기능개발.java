package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_기능개발 {

    static int[] progresses = {93, 30, 55};
    static int[] speeds = {1, 30, 5};
    static int time, day;
//    static int[] days;

    public static void main(String[] args) {

        //1. 작업 일수를 계산해서 큐에 넣는다.
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            time = 0; day = 0;
            time = 100 - progresses[i];
            day = (time/speeds[i]);
            if(time%speeds[i] > 0) day += 1;
            q.add(day);
        }
        //System.out.println(q);

        //2. 순서대로 큐의 값을 꺼내고, 꺼낸 값이 다음 값보다 큰지 확인. 크면 cnt++
        List<Integer> list = new LinkedList<>();

        while(!q.isEmpty()){
            int value = q.poll(); //poll은 꺼내는 거
            int cnt = 1;

            while(!q.isEmpty() && value >= q.peek()) { //peek은 값 확인하는 거
                cnt++;
                q.poll();
            }
            list.add(cnt);
        }
        //list to array 이제 좀 외우기
        int[] answer = list.stream().mapToInt(i -> i).toArray();

        /* 틀린 답
        int[] answer = {};

        int length = progresses.length;
        days = new int[length];
        for(int i=0; i<length; i++) {
            time = 0; day = 0;
            time = 100 - progresses[i];
            day = (time/speeds[i]);
            if(time%speeds[i] > 0) day += 1;

            days[i] = day;
        }
        System.out.println(Arrays.toString(days));

        int result = 1;
        Queue<Integer> q = new LinkedList<>();
        for(int j=0; j<days.length-1; j++) {
            if(days[j] >= days[j+1]){
                result++;
            } else {
                q.offer(Integer.valueOf(result));
                result = 1;
            }
        }
        q.offer(Integer.valueOf(result));

        int size = q.size();
        answer = new int[size];
        int cnt = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            answer[cnt] = temp;
            cnt++;
        }
        */
        //return answer;
        System.out.println(Arrays.toString(answer));

    }
}
