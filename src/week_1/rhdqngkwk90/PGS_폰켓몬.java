package week_1.rhdqngkwk90;

import java.util.*;

public class PGS_폰켓몬 {

    static int[] nums = {3, 1, 2, 3};

    public static void main(String[] args) {
        int answer = 0;

        //해시 사용
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            //같은 Key가 있으면 2, 기본 1
            map.put(i, map.getOrDefault(i, 0) +1);
        }
        //선택 가능 개수와 중복 제외한 폰켓몬 개수 비교
        if(nums.length/2 <= map.size()) {
            answer = nums.length/2;
        } else {
            answer = map.size();
        }

        /* 기존 풀이
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        int length = nums.length;
        for(int i=0; i<length; i++){
            if(!list.contains(nums[i])){list.add(nums[i]);}
        }
        int size = list.size();
        if(size >= length/2){answer = length/2;}
        else{answer = size;}
        */

        //return answer;
        System.out.println(answer); //2
    }

}
