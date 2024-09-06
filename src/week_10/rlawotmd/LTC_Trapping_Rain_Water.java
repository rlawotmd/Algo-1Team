package week_10.rlawotmd;

public class LTC_Trapping_Rain_Water {
    static int trap(int[] height) {
        int answer = 0;
        int start = 0;
        int end = height.length - 1;
        int left_h = 0;
        int right_h = 0;

        while (start < end) {
            left_h = Math.max(left_h, height[start]);
            right_h = Math.max(right_h, height[end]);
            if (left_h <= right_h) {
                answer += left_h - height[start++];
            }
            else {
                answer += right_h - height[end--];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height)); // 6

        height = new int[] {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height)); // 9
    }
}
