package week_1.rlawotmd;

import java.util.*;

public class PGS_베스트앨범 {
    static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Set<String> kl = new HashSet<>(Arrays.asList(genres));
        Map<String, Integer> m = new HashMap<>();
        Map<String, List<int[]>> ml = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!m.containsKey(genres[i])) {
                m.put(genres[i], 0);
                ml.put(genres[i], new ArrayList<>());
            }
            m.put(genres[i], m.get(genres[i]) + plays[i]);
            ml.get(genres[i]).add(new int[]{i, plays[i]});
        }

        List<Object[]> total = new ArrayList<>();

        for (String s : kl) {
            Collections.sort(ml.get(s), (o1, o2) -> -Integer.compare(o1[1], o2[1]));
            total.add(new Object[]{s, m.get(s)});
        }

        Collections.sort(total, (o1, o2) -> -Integer.compare((int) o1[1], (int) o2[1]));

        System.out.println(total);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < total.size(); i++) {
            String s = (String) total.get(i)[0];
            ans.add(ml.get(s).get(0)[0]);
            if (ml.get(s).size() > 1) {
                ans.add(ml.get(s).get(1)[0]);
            }
        }

        answer = ans.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[] {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
