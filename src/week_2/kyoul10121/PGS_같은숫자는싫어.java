package week_2.kyoul10121;

import java.util.*;

public class PGS_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
    int[] answer = {};

    Stack<Integer> stackInt = new Stack<>();
    for (int i = 0; i < arr.length; i++) {

        if(i==0) stackInt.push(arr[i]);
        else if(stackInt.peek() != arr[i]) stackInt.push(arr[i]);
    }

    answer = new int[stackInt.size()];
    for(int i = stackInt.size()-1; i>=0; i--){
        answer[i] = stackInt.pop();
    }

    return answer;

    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));

        arr = new int[] {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr)));

    }

}