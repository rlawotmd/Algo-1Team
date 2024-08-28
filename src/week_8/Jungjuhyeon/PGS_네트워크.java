package week_8.Jungjuhyeon;

public class PGS_네트워크 {
    static int[] p;
    public static int solution(int n, int[][] computers) {
        p = new int[n+1]; //1~n부모

        for(int i=1;i<n+1;i++){
            p[i] = i;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(computers[i][j] ==1){
                    union(i+1,j+1);
                }
            }
        }


        // 네트워크 개수 세기
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(find(i) == i) {
                answer++;
            }
        }

        return answer;

    }

    public static void union(int i,int j){
        int aRoot = find(i);
        int bRoot = find(j);

        p[bRoot] = aRoot;
    }

    public static int find(int i){
        if(p[i]==i) return p[i];
        return p[i] = find(p[i]);
    }

    public static void main(String[] args){
        int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = solution(3,computers);
        System.out.println(answer);

    }
}
