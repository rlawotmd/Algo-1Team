package week_2.Jungjuhyeon;

import java.util.*;

public class PGS_같은숫자는싫어 {
    public static void main(String[] args){
        int[] arr = new int[] {1, 1, 3, 3, 0, 1, 1};
        System.out.println(Arrays.toString(solution(arr)));

        arr = new int[] {4, 4, 4, 3, 3};
        System.out.println(Arrays.toString(solution(arr)));

    }
    static int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();
        // 중복 값 제거
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }
        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;

    }
}
