package week_6.rhdqngkwk90;

import java.util.Arrays;

public class PGS_조이스틱 {

    //입력
    static String name = "JEROEN";

    //출력
    public static void main(String[] args){
        int answer = solution(name);
        System.out.println(answer);
    }

    static int solution(String name) {
        int answer = 0;

        /* 첫 번째 시도) 이 문제에서 중요한 건 좌우 커서 이동의 최적해를 구해야 한다는 것이다.
                        1) 각 문자의 알파벳 이동 횟수 구하기
                        2) 양옆 알파벳간의 이동 횟수 구하기
        */

        int n = name.length();
        int[] move = new int[n]; //1) 각 문자의 알파벳 이동 횟수 구하기
        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            move[i] = Math.min(c - 'A', 'Z' - c + 1);
        }
        //System.out.println(Arrays.toString(move));

        //2) 양옆 알파벳간의 이동 횟수 구하기 - 여기는 모르겠어서 ChatGPT 찾아봄
        // 커서를 이동하는 데 필요한 최소 이동 횟수 계산
        int minMove = n - 1;  // 초기값: 모든 문자에 대해 커서가 한 번도 이동하지 않는 경우
        int right = 0;  // 커서가 오른쪽으로 이동할 때의 총 이동 횟수

        for (int i = 0; i < n; i++) {
            // 연속된 이동 거리 계산
            int next = i + 1;
            while (next < n && move[next] == 0) {
                next++;
            }
            //이렇게 쓰는 거 처음봄
            minMove = Math.min(minMove, Math.min(i + n - next + Math.min(i, n - next), i + n - next + Math.min(n - next, next)));
        }

        answer += Arrays.stream(move).sum();  // 각 문자를 만들기 위한 총 조작 횟수
        answer += minMove;  // 커서를 이동하는 데 필요한 최소 조작 횟수

        return answer;
    }


}
