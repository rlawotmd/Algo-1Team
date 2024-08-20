package week_7.rlawotmd;

public class PGS_정수삼각형 {
    static int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] = triangle[i - 1][0] + triangle[i][0];
            triangle[i][triangle[i].length - 1] = triangle[i][triangle[i].length - 1] + triangle[i - 1][triangle[i].length - 2];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
            }
        }

        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}
