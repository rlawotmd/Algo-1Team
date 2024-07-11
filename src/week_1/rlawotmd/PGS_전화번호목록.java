package week_1.rlawotmd;

import java.util.HashMap;

public class PGS_전화번호목록 {
    static boolean solution(String[] phone_book) {
        HashMap<String, String> hm = new HashMap<>();

        for (String s : phone_book) {
            hm.put(s, s);
        }

        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                String str = s.substring(0, i);
                if (hm.containsKey(str)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"97674223", "1195524421", "119"};
        System.out.println(solution(arr));

        arr = new String[] {"123","456","789"};
        System.out.println(solution(arr));

        arr = new String[] {"12","123","1235","567","88"};
        System.out.println(solution(arr));

        // F T F
    }
}
