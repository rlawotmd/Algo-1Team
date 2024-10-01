package week_6.rlawotmd;

public class PGS_체육복 {
    static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] arr = new int[n];
        int[] check = {-1, 1};

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1] -= 1;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                answer++;
                continue;
            }
            for (int j = 0; j < 2; j++) {
                int loc = i + check[j];
                if (loc < 0 || loc > n - 1) continue;
                if (arr[loc] == 1) {
                    arr[loc] = 0;
                    arr[i] = 0;
                    answer++;
                    break;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(5, lost, reserve)); // 5

        lost = new int[] {2, 4};
        reserve = new int[] {3};
        System.out.println(solution(5, lost, reserve)); // 4

        lost = new int[] {3};
        reserve = new int[] {1};
        System.out.println(solution(3, lost, reserve)); // 2
    }
}
