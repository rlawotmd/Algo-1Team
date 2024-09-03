package week_9.rlawotmd;

import java.util.Arrays;
import java.util.Stack;

public class PGS_여행경로 {
    static boolean[] v;
    static String[] answer;
    static Stack<String> s = new Stack<>();

    static void dfs(String[][] tickets, String loc, int cnt) {
        if (cnt == tickets.length) {
            for (int i = tickets.length; i >= 0; i--) {
                answer[i] = s.pop();
            }
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (v[i]) continue;
            if (tickets[i][0].equals(loc)) {
                v[i] = true;
                s.push(tickets[i][1]);
                dfs(tickets, tickets[i][1], cnt + 1);
                v[i] = false;
                if (s.isEmpty()) return;
                s.pop();
            }
        }
    }

    static String[] solution(String[][] tickets) {
        answer = new String[tickets.length + 1];
        v = new boolean[tickets.length];
        Arrays.sort(tickets, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));

        answer[0] = "ICN";
        s.push("ICN");

        dfs(tickets, "ICN", 0);

        return answer;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(solution(tickets))); // "ICN", "JFK", "HND", "IAD"

        tickets = new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets))); // "ICN", "ATL", "ICN", "SFO", "ATL", "SFO"
    }
}
