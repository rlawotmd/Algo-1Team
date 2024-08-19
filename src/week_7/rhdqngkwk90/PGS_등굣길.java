package week_7.rhdqngkwk90;

public class PGS_등굣길 {

    //입력
    static int m = 4, n = 3;
    static int[][] puddles = {{2, 2}};

    //출력
    public static void main(String[] args){
        int answer = solution(m, n, puddles);
        System.out.println(answer);
    }

    static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        /*
        m * n 크기
        시작 : (1,1)
        도착 : (m,n)
        오른쪽과 아래쪽으로만 움직임
        최단경로 개수를 1,000,000,007로 나눈 나머지 구하기
        물에 잠긴 지역은 0개 이상 10개 이하
        -> 순열이나 dfs 쓰려고 하다가 너무 어려운 것 같아서 그냥최단거리 구하는 방식 사용

        < 최단거리 구하는 방법 >

        시작 ■  ■  ■
         ■  ■  ■  ■
         ■  ■  ■  도착
         -> 각 칸으로 이동할 수 있는 경우의 수를 생각해보면

         시작  1  1  1
          1   2  3  4
          1   3  6  10
          -> 이런식으로 오른쪽, 아래로 이동하면서 위에서 오는 수와 왼쪽에서 오는 수를 더한 값이 경우의 수가 된다.

         시작  1  1  1
          1   ●  1  2
          1   1  2  4
          -> 특정 구역이 물에 잠겼다면 다음과 같이 구할 수 있다.
        */

        //1. 물에 잠긴 지역에 -1을 넣어준다. - 구분을 위해서
        int[][] board = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1;
        }

        //시작 위치의 값을 1로 설정
        board[1][1] = 1;

        //2. 오른쪽, 아래쪽으로 이동하면서 최단거리 구하기
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {

                if(board[i][j] == -1) continue;
                //        상 우 하 좌
                // i = { -1, 0, 1, 0 }
                // j = {  0, 1, 0, -1 }
                //위에서 오는 경우, 왼쪽에서 오는 경우를 합하면 경우의 수가 된다.
                if(board[i-1][j] > 0) {
                    board[i][j] = (board[i][j] + board[i-1][j]) % 1000000007; //효율성 테스트 때문에 매번 나눠준다.
                }
                if(board[i][j-1] > 0) {
                    board[i][j] = (board[i][j] + board[i][j-1]) % 1000000007;
                }

            }
        }

        answer = board[n][m] % 1000000007;

        return answer;
    }
}
