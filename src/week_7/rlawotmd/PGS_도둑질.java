package week_7.rlawotmd;

public class PGS_도둑질 {
    static int solution(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2];

        if (money.length > 3) dp[2] += dp[0];

        int ans1 = Math.max(Math.max(dp[0], dp[1]), dp[2]);
        for (int i = 3; i < money.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + money[i];
            ans1 = Math.max(ans1, dp[i]);
        }

        dp[0] = 0;
        dp[1] = money[1];
        dp[2] = money[2];
        int ans2 = Math.max(dp[1], dp[2]);
        for (int i = 3; i < money.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + money[i];
            ans2 = Math.max(ans2, dp[i]);
        }

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        int[] money = new int[]{1000, 10, 20, 2000, 500};
        System.out.println(solution(money)); // 4
    }
}
