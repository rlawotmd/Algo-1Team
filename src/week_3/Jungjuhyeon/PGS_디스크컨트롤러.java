package week_3.Jungjuhyeon;
import java.util.*;

public class PGS_디스크컨트롤러 {
    static int solution(int[][] jobs) {
        Arrays.sort(jobs,(o1,o2)-> Integer.compare(o1[0],o2[0])); //시작시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1],o2[1])); //소요시간

        int idx =0, time = jobs[0][0],answer =0; //현재시각
        while(idx< jobs.length || !pq.isEmpty()){
            while(idx<jobs.length && jobs[idx][0] <=time){
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
            int[] work = pq.poll();
            time +=work[1];
            answer+= time-work[0];
        }
        return answer/jobs.length;


    }
    public static void main(String[] args)throws Exception{
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = solution(jobs);
        System.out.println(answer);
    }


}
