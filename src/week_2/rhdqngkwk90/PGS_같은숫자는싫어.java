package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_같은숫자는싫어 {

    static int []arr = {1, 1, 3, 3, 0, 1, 1};

    public static void main(String[] args) {

        Integer[] answer = {};

        // 1. 스택 사용
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]) st.push(arr[i]);
        }
        st.push(arr[arr.length-1]);
        answer = st.toArray(new Integer[st.size()]);
        /*
        테스트 1 〉	통과 (23.91ms, 117MB)
        테스트 2 〉	통과 (24.24ms, 111MB)
        테스트 3 〉	통과 (23.66ms, 117MB)
        테스트 4 〉	통과 (24.47ms, 111MB)
        */

        /* 2. 큐 사용
        Queue pq = new LinkedList<>();

        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]) pq.offer(arr[i]);
        }
        pq.offer(arr[arr.length-1]);
        Object[] oArr = pq.toArray();

        answer = new Integer[oArr.length];
        for(int j=0; j<oArr.length; j++) answer[j] = (Integer) oArr[j];

        테스트 1 〉	통과 (34.81ms, 107MB)
        테스트 2 〉	통과 (33.90ms, 108MB)
        테스트 3 〉	통과 (33.95ms, 108MB)
        테스트 4 〉	통과 (34.31ms, 108MB)
        */

        /* 기존 풀이
        ArrayList<Integer> list = new ArrayList<>();
        int length = arr.length-1;
        for(int i=0; i<length; i++){
            if(arr[i] != arr[i+1])
            list.add(arr[i]); //다르면 ArrayList에 추가
        }
        list.add(arr[length]); //마지막 요소 추가

        int size = list.size(); //ArrayList 사이즈
        answer = list.toArray(new Integer[size]); //ArrayList ⇨ answer 배열에 넣기

        테스트 1 〉	통과 (21.54ms, 109MB)
        테스트 2 〉	통과 (21.18ms, 110MB)
        테스트 3 〉	통과 (21.02ms, 110MB)
        테스트 4 〉	통과 (23.57ms, 112MB)
        */

        //return answer;
        System.out.println(Arrays.toString(answer));

    }
}
