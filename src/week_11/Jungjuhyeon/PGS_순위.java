package week_11.Jungjuhyeon;

public class PGS_순위 {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd_machal = new int[n+1][n+1];

        for(int i=0;i<results.length;i++){
            int A = results[i][0];
            int B = results[i][1];

            //A>B
            floyd_machal[A][B] = 1;
            floyd_machal[B][A] = -1;

        }
        // 플로이드 워셜 알고리즘
        // 4 > 3 , 3 > 2 => 4 > 2
        for(int i = 1; i <= n; i++){ //출발
            for(int j = 1; j <= n; j++){ //도착
                for(int k = 1; k <= n; k++){ //경유
                    if(floyd_machal[i][k] == 1 && floyd_machal[k][j] == 1){
                        floyd_machal[i][j] = 1;
                        floyd_machal[j][i] = -1;
                    }
                    if(floyd_machal[i][k] == -1 && floyd_machal[k][j] == -1){
                        floyd_machal[i][j] = -1;
                        floyd_machal[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(floyd_machal[i][j] != 0) cnt++;
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }
    public static void main(String[] args){
        int [][] vertex = new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        int answer = solution(5,vertex);
        System.out.println(answer);

    }
}
