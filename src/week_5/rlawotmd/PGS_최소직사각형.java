package week_5.rlawotmd;

public class PGS_최소직사각형 {
    static int solution(int[][] sizes) {
        int max_x = 0;
        int max_y = 0;

        for (int i = 0; i < sizes.length; i++) {
            int x = Math.min(sizes[i][0], sizes[i][1]);
            int y = Math.max(sizes[i][0], sizes[i][1]);

            max_x = Math.max(max_x, x);
            max_y = Math.max(max_y, y);
        }

        return max_x * max_y;
    }

    public static void main(String[] args) {
        int[][] sizes = new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes)); // 4000

        sizes = new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution(sizes)); // 120

        sizes = new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(sizes)); // 133
    }
}
