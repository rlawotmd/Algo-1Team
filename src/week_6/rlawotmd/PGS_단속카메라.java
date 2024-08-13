package week_6.rlawotmd;

import java.util.Arrays;

public class PGS_단속카메라 {
    static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int cam = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] routes = new int[][] {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(solution(routes)); // 2
    }
}
