package week_2.rlawotmd;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PGS_주식가격 {
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        ArrayDeque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            // 반복문을 돌며 만약 이전의 주식보다 가격이 내려갈 경우 값을 바로 부여하고, 현재의 주식과 이전의 주식을 비교하여
            // 가격이 내려간 주신에 한하여 값 부여
            while (!s.isEmpty() && prices[s.peek()] > prices[i]) {
                answer[s.peek()] = i - s.pop();
            }
            s.push(i);
        }

        while (!s.isEmpty()) { // 스택에 남아있는 index 위치에 값 부여
            answer[s.peek()] = prices.length - s.pop() - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
}
/*
5, 4, 3, 2, 1 << ans : 1, 1, 1, 1, 0
 */