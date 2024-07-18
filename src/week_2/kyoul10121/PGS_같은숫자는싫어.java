package week_2.kyoul10121;

import java.util.*;

public class PGS_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
    int[] answer = {};

    Stack<Integer> stackInt = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
        if(i==0) stackInt.push(arr[i]); //우선 배열 인덱스가 0일 떄의 값을 스택에 삽입
        else if(stackInt.peek() != arr[i]) stackInt.push(arr[i]);   //인덱스 1부터는 peek(최상단)의 값이 arr[i]의 값과 일치하지 않을 경우에만 삽입
    }

    answer = new int[stackInt.size()];  //스택은 후입선출(LIFO)이기 때문에 거꾸로 삽입해준다.
    for(int i = stackInt.size()-1; i>=0; i--){  //스택 사이즈만큼 배열을 돌면서 스택에서 꺼낸 값을 담는데 후입선출이므로 역순으로 담아준다.
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