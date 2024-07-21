package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_주식가격 {

    static int[] prices = {1, 2, 3, 2, 3};

    public static void main(String[] args) {

        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        //return answer;
        System.out.println(Arrays.toString(answer));

    }
}
