package week_1.rlawotmd;

import java.util.*;

public class PGS_완주하지못한선수 {
    static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : participant) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else hm.put(s, 0);
        }

        for (String s : completion) {
            if (hm.get(s) > 0) {
                hm.put(s, hm.get(s) - 1);
            } else hm.remove(s);
        }

        for (int i = 0; i < participant.length; i++) {
            if (hm.containsKey(participant[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[] {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));

        participant = new String[] {"mislav", "stanko", "mislav", "ana"};
        completion = new String[] {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
