package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_다리를지나는트럭 {

    static int bridge_length = 2;
    static int weight = 10;
    static int[] truck_weights = {7, 4, 5, 6};

    public static void main(String[] args) {
        int answer = solution(bridge_length, weight, truck_weights);
        //return answer;
        System.out.println(answer);
    }
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>(); //큐 = 다리
        int sum = 0; //무게합
        int time = 0; //소요시간

        for(int truck : truck_weights) {  //전체 트럭을 다리에 올리며 무게 확인

            while(true) {
                //1. 다리가 비어있는 경우
                if(q.isEmpty()){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;

                    //2. 다리가 가득 차 있는 경우
                } else if(q.size() == bridge_length){
                    sum -= q.poll(); //한대 빼기

                    //3. 그외
                } else{
                    if(sum+truck <= weight) {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }

        }
        answer = time + bridge_length;
        return answer;

    }
}
