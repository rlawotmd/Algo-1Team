package week_8.rlawotmd;

public class PGS_단어변환 {
    static boolean[] v;
    static int answer = 0;

    private static void dfs(String begin, String target, String[] words, int n) {
        if (begin.equals(target)) {
            answer = n;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (v[i]) continue;

            int m = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) m++;
            }

            if (m == 1) {
                v[i] = true;
                dfs(words[i], target, words, n + 1);
                v[i] = false;
            }
        }
    }

    static int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words)); // 4

        //String[]
                words = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words)); // 0
    }
}
