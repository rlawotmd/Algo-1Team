package week_1.rhdqngkwk90;

import java.util.*;

public class PGS_완주하지못한선수 {
    static String[] participant = {"leo", "kiki", "eden"};
    static String[] completion = {"eden", "kiki"};

    public static void main(String[] args) {

        String answer ="";

        //해시 사용
        Map<String, Integer> map = new HashMap<>();

        for (String player : participant){
            //같은 Key가 있으면 2, 기본 1
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for (String player : completion){
            //완주 명단에 있으면 기본값(1) 빼기
            map.put(player, map.get(player) - 1);
        }

        for(String key : map.keySet()){
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        //return answer;
        System.out.println(answer); //leo


        /* 기존 풀이
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 1;
        for(i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];

        * 효율성  테스트
        //기존 풀이
        테스트 1 〉	통과 (163.88ms, 81.9MB)
        테스트 2 〉	통과 (256.76ms, 90.3MB)
        테스트 3 〉	통과 (278.03ms, 95.8MB)
        테스트 4 〉	통과 (293.25ms, 96.1MB)
        테스트 5 〉	통과 (241.32ms, 96.2MB)
        //해시 사용
        테스트 1 〉	통과 (39.36ms, 81.5MB)
        테스트 2 〉	통과 (62.03ms, 89.1MB)
        테스트 3 〉	통과 (66.60ms, 94.3MB)
        테스트 4 〉	통과 (72.08ms, 98MB)
        테스트 5 〉	통과 (71.92ms, 95.4MB)
        */
    }
}
