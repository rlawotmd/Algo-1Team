package week_6.rlawotmd;

import java.util.Stack;

public class PGS_큰수만들기 {
    static String solution(String number, int k) {
        String answer = "";
        int cnt = 0;

        Stack<Integer> s = new Stack<>();
        int[] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i) - '0';
        }
        s.push(arr[0]);
        for (int i = 1; i < number.length(); i++) {
            while (!s.isEmpty() && s.peek() < arr[i] && cnt < k) {
                s.pop();
                cnt++;
            }
            s.push(arr[i]);
            if (s.size() > arr.length - k) s.pop();
        }

        for (int i : s) answer = answer + i;

        if (answer.charAt(0) == '0') return "0";

        return answer;
    }

    public static void main(String[] args) {
        String number = "1934";
        int k = 2;
        System.out.println(solution(number, k)); // 94

        number = "1231234";
        k = 3;
        System.out.println(solution(number, k)); // 3234

        number = "4177252841";
        k = 4;
        System.out.println(solution(number, k)); // 775841

        number = "190000002";
        k = 3;
        System.out.println(solution(number, k)); // 900002

        number = "179252841";
        k = 6;
        System.out.println(solution(number, k)); // 984

        number = "10001";
        k = 3;
        System.out.println(solution(number, k));
    }
}
/*
        test case 6 : 통과 (7487.43ms, 87.5MB) / 7, 8, 9, 10 시간 초과 코드
        String answer = "";
        boolean[] v = new boolean[number.length()];
        int cnt = 0;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < number.length(); i++) {
            list.add(number.charAt(i) - '0');
        }

        while (cnt < k) {
            cnt++;

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) < list.get(i + 1)) {
                    list.remove(i);
                    break;
                }
                if (i == list.size() - 2) list.removeLast();
            }
        }
        if (list.get(0) == 0) return "0";

        for (int i : list) answer = answer + i;

        return answer;
*/
