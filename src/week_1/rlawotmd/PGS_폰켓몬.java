package week_1.rlawotmd;

import java.util.HashMap;

public class PGS_폰켓몬 {
    static int Solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        if (hm.size() > nums.length / 2) answer = nums.length / 2;
        else answer = hm.size();

        return answer;
    }

    public static void main(String[] args) {
        int[] c1 = {3, 1, 2, 3};
        System.out.println(Solution(c1));

        int[] c2 = {3, 3, 3, 2, 2, 4};
        System.out.println(Solution(c2));

        int[] c3 = {3, 3, 3, 2, 2, 2};
        System.out.println(Solution(c3));
    }
}
