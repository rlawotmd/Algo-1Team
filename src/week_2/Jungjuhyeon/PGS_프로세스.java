package week_2.Jungjuhyeon;

import java.util.*;

public class PGS_프로세스 {
    public static void main(String[] args){
        int[] priorities1 = new int[] {2, 1, 3, 2};
        int location1 = 2;
        System.out.println(solution(priorities1,location1));

        int[] priorities2 = new int[] {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        System.out.println(solution(priorities2,location2));

    }
    static int solution(int[] priorities, int location){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i=0;i<priorities.length;i++){
            q.offer(i);
            pq.offer(priorities[i]);
        }

        int count = 0;

        while(!q.isEmpty()){
            int idx = q.poll();


            if(priorities[idx] == pq.peek()){
                pq.poll();
                count++;
                if(idx == location){
                    break;
                }
            }
            else{
                q.offer(idx);
            }
        }
        return count;

    }
}
