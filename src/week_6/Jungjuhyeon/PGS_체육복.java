package week_6.Jungjuhyeon;

public class PGS_체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int[] answer = new int[n+1];

        for(int i=1;i<n+1;i++){ //처음에 1로 초기화
            answer[i] = 1;
        }
        for(int i:lost){ //lost에 적힌 인덱스를 전부 1씩 뺸다.
            answer[i] = 0;
        }
        for(int i:reserve){ //다시 여분의 체육복을 가진 사람의 인덱스에 +1씩 한다.
            answer[i] +=1;
        }
        for(int i=1;i<n;i++){
            if(answer[i]==0){
                if(answer[i-1]>=2){  //갯수가 0인 얘 주변에 2개 이상있는 애를 찾는다.
                    answer[i-1]--;
                    answer[i] =1;
                }else if(answer[i+1]>=2){
                    answer[i+1]--;
                    answer[i] =1;
                }
            }
        }
        if(answer[n]==0){  //마지막은 순환되지 않아서 마지막은 따로 빼서 해준다.
            if(answer[n-1]>=2){
                answer[n-1]--;
                answer[n] =1;
            }
        }
        int anw = n;
        for(int i=1;i<n+1;i++){
            if(answer[i] ==0){
                anw--;
            }
        }
        return anw;

        }
    public static void main(String[] args){
        int[] lost = new int[] {2,4};
        int[] reserve = new int[]{1,3,5};
        int s = solution(5,lost,reserve);
        System.out.println(s);

    }
}

// 1. n개의 배열을 선언해서,n개의 배열안에 1씩 다 집어넣는다.
// 2. lost에 있는 애들은 훔침을 당했으니 -1씩 뺴준다.
// 3. reserve에 있는 여분의 체육복을 가진 친구들은 +1씩 해준다.
// 4. 그리고 순환하면서, 0인 애들 주변을 -1,+1해서 찾아보고 빌려준다.
// 5. 그리고 answer에 0이있는 애들은 n에서 빼주고 그 갯수를 리턴한다.
