package week_1.Jungjuhyeon;

import java.io.*;
import java.util.*;

// 폰켓몬

public class PGS_폰켓몬 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] inputAry = input.split(",");

        int [] ia = new int[inputAry.length];

        for(int i=0;i<ia.length;i++){
            ia[i] = Integer.parseInt(inputAry[i]);
        }

        int answer = solution(ia);
        System.out.println(answer);

    }

    static int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        if (pickNum >= set.size()) {answer = set.size();
        } else {
            answer = pickNum;
        }

        return answer;
    }
}


