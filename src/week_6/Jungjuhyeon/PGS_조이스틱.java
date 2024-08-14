package week_6.Jungjuhyeon;

public class PGS_조이스틱 {
        public static int solution(String name) {
            int sum =0;

            int index; // 다음 값들을 확인할 때 사용
            int move = name.length() - 1; // 좌우 움직임 수를 체크

            for(int i=0;i<name.length();i++){
                char c = name.charAt(i);

                sum += Math.min(c-'A','Z'-c+1);

                index = i + 1;
                // 연속되는 A 갯수 확인
                while(index < name.length() && name.charAt(index) == 'A'){
                    index++;
                }
                move = Math.min(move, i * 2 + name.length() - index);
                // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
                // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
                move = Math.min(move, (name.length() - index) * 2 + i);

            }
            return sum + move;
        }
    public static void main(String[] args){
        int s = solution("JEROEN");
        System.out.println(s);

    }
}



// 1. +했을때랑 -했을때를 비교해서 그 값을 더해준다.
// 문제점 -> 왼쪾으로 커서를 하면 더 작을때 이건 어케 해야지