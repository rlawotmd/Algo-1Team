package week_6.rhdqngkwk90;

import java.util.*;

public class PGS_구명보트 {

    //입력
    static int[] people = {70, 50, 80, 50};
    static int limit = 100;

    //출력
    public static void main(String[] args){
        int answer = solution(people, limit);
        System.out.println(answer);
    }

    static int solution(int[] people, int limit) {
        int answer = 0;

        //구명보트 2명만 탈 수 있음
        //총 무게 제한 있음

        /*  첫 번째 시도) 전체 인원 몸무게 총합을 구하고, 보트 제한만큼 나눈다. (기본 보트 개수) 여기에 추가로 조합을 생각한다.
                         -> 애매하다.
        */
        /*
        두 번째 시도) 저번에 풀었던 우선순위 큐 2개 사용해서 max, min을 뽑아본다.
                     -> 예시 문제는 정답인데 제출하면 실패 뜸

        ChatGPT에 물어보니까 2가지 문제가 있음
        1. poll() 로 제거하면 큐의 요소가 재정렬되기 때문에 상태가 불확실 하다고 한다.
        2. minHeap에 가벼운사람을 add()하면 중복이 처리되거나 조합이 잘못 될 수 있다고 한다.

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        for (int p : people) {
            minHeap.add(p);
            maxHeap.add(p);
        }
        //System.out.println(pq);
        //System.out.println(rpq);

        while (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            int max = maxHeap.poll(); // 가장 무거운 사람 빼기
            int min = minHeap.poll(); // 가장 가벼운 사람 빼기
            //System.out.println(" max: "+max+" min: "+min);
            if (max + min <= limit) {
                answer++;
                //System.out.println("둘 다 태우기"+maxHeap+"++"+answer);
            } else {
                minHeap.add(min); //가벼운 사람은 남겨둠 - 다시 넣음
                answer++;
                //System.out.println("큰값빼기"+maxHeap+"++"+answer);
            }
        }
        */

        /*  세 번째 시도) 정렬하고 가장 양 끝의 사람들을 넣는다, 인덱스 증감
                        -> 포인터 개념을 잘 알면 풀 수 있다.
        */

        // 사람들의 몸무게를 오름차순으로 정렬
        Arrays.sort(people);
        int min = 0; // 가장 가벼운 사람 인덱스
        int max = people.length - 1; // 가장 무거운 사람 인덱스

        while (min <= max) {
            // 가장 무거운 사람과 가장 가벼운 사람이 구명보트에 함께 탈 수 있는지 확인
            if (people[min] + people[max] <= limit) {
                min++; // 가벼운 사람을 태움
                max--; // 무거운 사람을 태움
                answer++; // 구명보트 사용 개수 증가
            }else{
                max--; // 무거운 사람을 태움
                answer++; // 구명보트 사용 개수 증가
            }
        }

        return answer;
    }



}
