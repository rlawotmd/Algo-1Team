package week_3.rhdqngkwk90;

import java.util.*;

//우선순위 큐, 정렬 응용 문제
public class PGS_디스크컨트롤러 {

    //입력
    static int[][] jobs = {{0, 3},{1, 9},{2, 6}};

    //출력
    public static void main(String[] args) {
        int answer = solution(jobs);
        System.out.println(answer);
    }

    static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); //요청 시간순 정렬
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); //소요 시간순 정렬

        int time = 0;
        int wait = 0; //처리 순서
        int end = 0; //처리 끝난 후 시간
        int finishJob = 0; //처리된 작업

        while(jobs.length > finishJob){
            //남은 작업 존재, 현재 종료시간보다 요청시간이 빠를 때
            while(wait < jobs.length && jobs[wait][0] <= end){
                heap.offer(jobs[wait++]); //작업 추가
            }
            //초기 값 설정
            if(heap.isEmpty()){
                end = jobs[wait][0];
            }
            else{
                int[] job = heap.poll();
                time += job[1] + end - job[0]; //작업시간 + 작업이 종료된 시점 - 요청시간
                end += job[1];  //현재까지 처리된 작업 수
                finishJob++; //다음 작업
            }
        }
        answer = time / jobs.length;

        return answer;
    }

}
