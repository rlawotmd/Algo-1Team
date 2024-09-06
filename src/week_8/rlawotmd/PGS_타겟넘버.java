package week_8.rlawotmd;

public class PGS_타겟넘버 {
    static int answer;

    static void dfs(int[] numbers, int target, int cnt, int num) {
        if (cnt == numbers.length) {
            if (num == target) answer += 1;
            return;
        }
        dfs(numbers, target, cnt + 1, num + numbers[cnt]);
        dfs(numbers, target, cnt + 1, num - numbers[cnt]);
    }

    static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3)); // 5

        numbers = new int[] {4, 1, 2, 1};
        System.out.println(solution(numbers, 4)); // 2
    }
}
