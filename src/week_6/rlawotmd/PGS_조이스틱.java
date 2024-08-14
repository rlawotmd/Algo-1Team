package week_6.rlawotmd;

public class PGS_조이스틱 {
    static int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // i까지 갔다 돌아가는 경우와, 반대로 가는 경우 중 최소 이동 거리
            move = Math.min(move, i + name.length() - next + Math.min(i, name.length() - next));
        }

        answer += move;
        return answer;
    }

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name)); // 56

        name = "JAN";
        System.out.println(solution(name)); // 23

        name = "JAZ";
        System.out.println(solution(name)); // 11

        name = "AZAAAAAAAAAAAAAAAAAZA";
        System.out.println(solution(name)); // 6

        name = "BBBBAAAABA";
        System.out.println(solution(name)); // 12
    }
}
/*
        int answer = 0;
        String[] arr = name.split("");
        String[] s = new String[name.length()];
        Arrays.fill(s, "A");

        int idx = 0, next, prev;

        while (!Arrays.equals(arr, s)) {
            if (!arr[idx].equals(s[idx])) {
                answer += Math.min(arr[idx].charAt(0) - 'A', 'Z' - arr[idx].charAt(0) + 1);
                s[idx] = arr[idx];
            }

            if (Arrays.equals(arr, s)) break;

            next = (idx + 1) % arr.length;
            prev = (arr.length - 1 + idx) % arr.length;

            while (arr[next].equals(s[next]) && arr[prev].equals(s[prev])) {
                next = (next + 1) % arr.length;
                prev = prev - 1;
                if (prev < 0) prev += arr.length;
            }

            if (!arr[next].equals(s[next]) && !arr[prev].equals(s[prev])) {
                int one = (next + 1) % arr.length;
                int more = prev - 1;
                if (more < 0) more += arr.length;
                while (!arr[one].equals(s[one]) && !arr[more].equals(s[more])) {
                    one = (one + 1) % arr.length;
                    more = more - 1;
                    if (more < 0) more += arr.length;
                }
                if(!arr[one].equals(s[one])) {
                    answer += Math.min(Math.max(idx, next) - Math.min(idx, next)
                            , arr.length - Math.max(idx, next) + Math.min(idx, next));
                    idx = next;
                }
                if (!arr[more].equals(s[more])) {
                    answer += Math.min(Math.max(idx, prev) - Math.min(idx, prev)
                            , arr.length - Math.max(idx, prev) + Math.min(idx, prev));
                    idx = prev;
                }
            }

            if (!arr[next].equals(s[next])) {
                answer += Math.min(Math.max(idx, next) - Math.min(idx, next)
                        , arr.length - Math.max(idx, next) + Math.min(idx, next));
                idx = next;
                continue;
            }

            if (!arr[prev].equals(s[prev])) {
                answer += Math.min(Math.max(idx, prev) - Math.min(idx, prev)
                        , arr.length - Math.max(idx, prev) + Math.min(idx, prev));
                idx = prev;
            }
        }

        return answer;
 */