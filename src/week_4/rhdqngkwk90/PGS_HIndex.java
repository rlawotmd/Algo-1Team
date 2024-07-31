package week_4.rhdqngkwk90;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//우선순위 큐 2개 사용
public class PGS_HIndex {

    //입력
    static String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

    //출력
    public static void main(String[] args) {
        int [] answer = solution(operations);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(String[] operations) {
        //오름차순 우선순위 큐
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //내림차순 우선순위 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(String o : operations){

            String type = o.substring(0,1);
            int num = Integer.parseInt(o.substring(2));

            switch(type) {
                case "I" :
                    minHeap.add(num); //offer 안됨
                    maxHeap.add(num);
                    break;
                case "D" :
                    if(maxHeap.isEmpty()) break;
                    if(num == 1) {
                        int del = maxHeap.poll();
                        minHeap.remove(del); //poll 안됨
                    }
                    if(num == -1) {
                        int del = minHeap.poll();
                        maxHeap.remove(del);
                    }

            }

        }
        if(maxHeap.isEmpty()) return new int[] {0, 0};

        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}
