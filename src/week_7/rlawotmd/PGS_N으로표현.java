package week_7.rlawotmd;

import java.util.HashSet;
import java.util.Set;

public class PGS_N으로표현 {
    static int solution(int N, int number) {
        int answer = -1;
        int num = N;
        Set<Integer>[] sArr = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            sArr[i] = new HashSet<>();
            sArr[i].add(num);
            num = num * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : sArr[j]) {
                    for (int b : sArr[i - j]) {
                        sArr[i].add(a + b);
                        sArr[i].add(a - b);
                        sArr[i].add(b - a);
                        sArr[i].add(a * b);
                        if (a != 0) sArr[i].add(b + a);
                        if (b != 0) sArr[i].add(a / b);
                    }
                }
            }
        }

        for (int i = 1; i < 9; i++) {
            if (sArr[i].contains(number)) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int number = 12;
        System.out.println(solution(n, number)); // 4

        n = 2;
        number = 11;
        System.out.println(solution(n, number)); // 3
    }
}
