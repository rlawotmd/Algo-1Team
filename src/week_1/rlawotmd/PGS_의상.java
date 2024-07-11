package week_1.rlawotmd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PGS_의상 {
    static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            }
            else {
                hm.put(key, 1);
                sb.append(key + " ");
            }
        }

        st = new StringTokenizer(sb.toString(), " ");

        if (hm.size() == 1) answer *= hm.get(st.nextToken());
        else {
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                answer *= (hm.get(key) + 1);
            }
            answer -= 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] clothes = new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes)); // 5

        clothes = new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        System.out.println(solution(clothes)); // 3
    }
}
