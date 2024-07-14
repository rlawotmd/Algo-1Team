package week_1.kyoul10121;

/*
조합 관련 문제는 항상 경우의 수를 생각해야 한다.
2차원 배열로 받는 경우들을 for문을 통해 map의 key-value 형태로 먼저 만들어준다.
2차원 배열의 1번째 요소는 의상의 타입이므로, 의상 타입이 겹칠 시, 해당 의상의 카운트를 하나 올려준다.
입는 경우와 안 입는 경우를 생각해서 계산해야 한다.
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PGS_의상 {
    public int solution(String[][] clothes) {

        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        Iterator<Integer> iter = hm.values().iterator();

        while (iter.hasNext()) {
            answer *= iter.next().intValue() + 1;
        }

        return answer - 1;  //아무것도 입지 않는 경우는 제외하기 때문에 1을 빼준다.
    }
}
