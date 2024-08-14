package week_6.rlawotmd;

import java.util.*;

public class PGS_구명보트 {
    static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int point = 0;

        for (int i = people.length - 1; i >= point; i--) {
            if (people[i] + people[point] <= limit) {
                answer++;
                point++;
                continue;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        System.out.println(solution(people, 100)); // 3

        people = new int[]{110, 40, 40, 40, 40, 50};
        System.out.println(solution(people, 160)); // 3

        people = new int[]{60, 60, 60, 60};
        System.out.println(solution(people, 240)); // 3
    }
}
