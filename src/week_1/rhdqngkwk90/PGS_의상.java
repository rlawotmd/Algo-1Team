package week_1.rhdqngkwk90;

import java.util.*;

public class PGS_의상 {

    static String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
    };

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int answer = 1; //곱해야됨
        for(String[] arr : clothes){
            //같은 key(arr[1])가 있으면 +1, 아니면 기본값 2 (입고 안입고)
            map.put(arr[1], map.getOrDefault(arr[1], 1) + 1);
        }
        for(String str : map.keySet()){
            int num = map.get(str);

            answer *= num;
        }

        //return answer-1;
        System.out.println(answer-1); //5
    }
}
