package week_5.rlawotmd;

public class PGS_모음사전 {
    static int count = 0, answer;
    static String[] s = {"A", "E", "I", "O", "U"};
    static String find;
    static String[] arr = new String[5];
    static boolean is_find = false;

    static void check(String s) {
        if (s.equals(find)) {
            is_find = true;
            answer = count;
        }
    }

    static void Prim(int cnt) {
        for (int i = 0; i < 5; i++) {
            if (is_find) return;
            count++;
            arr[cnt] = s[i];
            String ans = "";
            for (String s : arr) {
                if (s == null) break;
                ans = ans + s;
            }
            check(ans);
            if (cnt < 4) Prim(cnt + 1);
            arr[cnt] = null;
        }
    }

    static int solution(String word) {
        find = word;

        Prim(0);

        return answer;
    }

    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
        count = 0;
        is_find = false;

        word = new String("AAAE");
        System.out.println(solution(word));
        count = 0;
        is_find = false;

        word = new String("I");
        System.out.println(solution(word));
        count = 0;
        is_find = false;

        word = new String("EIO");
        System.out.println(solution(word));
    }
}
