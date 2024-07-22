package week_2.kyoul10121;

import java.util.Arrays;

public class PGS_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));
    }
    // 이중 반복문을 이용해 특정 시점과 그 이후의 시점들의 가격을 비교해 가격이 떨어지지 않은 시간을 1초씩 증가시키고, 만약 가격이 떨어지게 된다면 반복문을 종료한다
        public static int[] solution(int[] prices) {
            int[] ans = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    ans[i]++;
                    if (prices[i] > prices[j])
                        break;
                }
            }
            return ans;
        }

}
