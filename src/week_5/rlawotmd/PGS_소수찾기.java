package week_5.rlawotmd;

import java.util.ArrayList;

public class PGS_소수찾기 {
    static boolean[] v;
    static int answer;
    static ArrayList<Integer> list;
    static String[] arr;

    static boolean check(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void Perm(String[] s, int cnt, int length) {
        if (cnt == length) {
            String n = "";

            for (String str : s) {
                if (str == null) continue;
                n = n + str;
            }

            int num = Integer.parseInt(n);
            System.out.println(num);
            if (list.contains(num)) return;
            if (check(num)) list.add(num);

            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            s[cnt] = arr[i];
            Perm(s, cnt + 1, length);
            v[i] = false;
        }
    }

    static int solution(String numbers) {
        answer = 0;

        arr = new String[numbers.length()];
        String[] s;

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) + "";
        }

        v = new boolean[numbers.length()];
        list = new ArrayList<>();

        for (int i = 1; i <= numbers.length(); i++) {
            s = new String[numbers.length()];
            Perm(s, 0, i);
        }

        return list.size();
    }

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers)); // 3

        System.out.println();

        numbers = "011";
        System.out.println(solution(numbers)); // 2
    }
}
