package week_7.rhdqngkwk90;

public class PGS_도둑질 {

    //입력
    static int[] money = {1, 2, 3, 1};

    //출력
    public static void main(String[] args){
        int answer = solution(money);
        System.out.println(answer);
    }

    static int solution(int[] money) {
        int answer = 0;

        /*
        3. 검색한 정답
        -> 왜 두가지 경우만 비교하는건지 모르겠음
        */
        int n = money.length;

        // 집이 3개인 경우, 각 집의 돈을 직접 비교
        if (n == 3) return Math.max(money[0], Math.max(money[1], money[2]));

        // 첫 번째 집을 포함하는 경우 (마지막 집 제외)
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        for (int i=2; i<n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }

        // 첫 번째 집을 제외하는 경우 (마지막 집 포함)
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        for (int i=3; i<n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        // 두 경우 중 최대값 반환
        return Math.max(dp1[n-2], dp2[n-1]);

        /*
        2. Queue 사용
        하나씩 건너서 탐색, (집 개수/2개) 만큼 방문한다.
        큐에다가 넣고 빼고 하면 비효율적이긴 한데 동작 원리 잘 알 수 있을 것 같아서 시도해 본다.
        -> 차라리 시간 초과가 났으면...고냥 실패뜸

        Queue<Integer> q = new LinkedList<>();
        for(int m : money) q.offer(m); //System.out.println("큐 : "+q);

        //모든 집을 시작점으로 잡고 순회
        for(int i=0; i<length; i++){

            int sum = 0;
            //(집의개수/2) 만큼만 순회
            for(int k=0; k<num; k++){

                //방문
                int visitY = q.poll();
                sum += visitY;
                //System.out.println("방문지점 : "+visitY+" , 꺼낸 후 큐 : "+q+" , 합 : "+sum);
                //큐에 넣기
                q.offer(visitY);

                //한집 건너뜀
                int visitN = q.poll();
                //큐에 넣기
                q.offer(visitN);

                //System.out.println("현재 큐 : "+q);

                //돌면서 max값 구하기
                max = Math.max(max,sum);
            }

            //한번 돌고 나서 시작지점 변경 - 빼고 다시 넣기
            int start = q.poll();
            q.offer(start);
            //System.out.println("시작지점 : "+start+" , 큐 : "+q);
        }

        answer = max;
        return answer;

        */

        /*
        1. Map 사용
        돈 많은 순서대로 방문, 인접한 곳이면 X, 방문했으면 방문 처리하기
        인덱스 값(key) 돈(value)(기준) 정렬, for문 돌면서 확인
        사실 Map 안 써도 될 것 같은디 일단 해보기
        -> Map 내림차순 정렬까지는 괜찮았는데, 그 순서로 탐색하니까 인접해있는지 확인이 잘 안됨
        -> 최댓값을 내가 판단하는 게 아니라 다 구해보고 Max를 구해야 된다.

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<money.length; i++){
            int key = i;
            int value = money[i];
            map.put(key,value);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1,o2)-> (map.get(o2).compareTo(map.get(o1))));

        System.out.println(map);
        int preKey = -1;
        for (Integer key : keySetList) {
            System.out.println("preKey : "+preKey);
            System.out.println("key : "+key);

            if((preKey-1) != key && (preKey+1) != key) {
                answer += map.get(key);
                map.put(key, -1);
                System.out.println("방문처리"+map);
            }

            System.out.println((preKey-1)+" | "+key+" | "+(preKey+1)+" answer : "+answer);
            preKey = key;
        }
        */
    }
}
