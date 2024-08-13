package week_6.rhdqngkwk90;

import java.util.*;

public class PGS_큰수만들기 {

    //입력
    static String number = "1231234";
    static int k = 3;

    //    static int N, R;
    //    static int[] a, b;
    //    static String answer = "";
    //    static List<String> list = new ArrayList<>();
    //    static PriorityQueue<String> pq = new PriorityQueue<>();

    //출력
    public static void main(String[] args){
        String answer = solution(number, k);
        System.out.println(answer);
    }

    static String solution(String number, int k) {
        String answer = "";

        /* 첫 번째 시도) 배열에 넣고 내림차순 정렬, k개 빼기
           결과) 있는 순서에서 숫자만 빠져야 됨. 순서 변경은 불가

        N = number.length();
        String numArr[] = number.split("");
        Arrays.sort(numArr, Collections.reverseOrder());
        for(int i=0; i<length-k; i++){
            answer += numArr[i];
        }

         */

        /* 두 번째 시도) (길이-k)개 만큼의 숫자 뽑는 조합 다 만들고 내림차순
           결과) 답은 나오지만 시간 초과 뜬다 - 완전 탐색 풀이

        N = number.length();
        a = new int[N];
        String[] numArr = number.split("");
        for(int i=0; i<N; i++) a[i] = Integer.parseInt(numArr[i]);

        R = N - k;
        b = new int[R];

        comb(0, 0);

        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0);

         */

        /* 세 번째 시도) 다 구하고 list에 넣는 방식이 비효율적인가 싶어서 내림차순 우선순위 큐 사용해 보기
           결과) 시간 초과 - 조합을 사용하는 것이 잘못된 것 같다.

        N = number.length();
        a = new int[N];
        for (int i=0; i<N; i++) a[i] = Character.getNumericValue(number.charAt(i));

        R = N - k;
        b = new int[R];

        comb(0, 0);

        answer = pq.poll();

        */

        /* 네 번째 시도) 조합을 구하지 말고 문자열 인덱스 for문 돌리면서 우선순위 큐에 넣었다 뺐다 해보기
                       (참고)dequeue:우선순위 높은 원소 삭제 후 반환)
                       근데 이건 조합을 어떻게 따짐...? 인덱스만으로 조합을 만들 수 있나 - 검색해 보기
           결과) 큐가 아니라 스택을 사용하라고 한다.
        */

        /* 다섯 번째 시도) 검색해 보니까 가장 큰 수를 찾아서 k 만큼 자르라는 천재적인 풀이를 봄. 해보기
           결과) 성공!
        */

        StringBuilder answerBuilder = new StringBuilder(); //시간 줄이기 위해 사용

        char[] numArr = number.toCharArray();
        int length = numArr.length - k;

        int start = 0; //문자 비교를 시작하는 인덱스를 나타내는 start 변수

        //"1231234"
        for(int i=0; i<length; i++) {
            char max = '0';

            //"1231234"
            for(int j=start; j<=i+k; j++) {
                if(numArr[j] > max) { //가장 큰수 골라서 다음 인덱스부터 시작
                    max = numArr[j];
                    start = j+1;
                    //System.out.println("start : "+numArr[j]);
                }
            }
            //System.out.println("붙이는 max : "+max);
            answerBuilder.append(Character.toString(max));
        }
        answer = answerBuilder.toString();
        return answer;
    }

    /*
	static void comb(int cnt, int start) {
	    //탈출구문
	 	if(cnt==R) {
	 		for(int num : b) answer += Integer.toString(num);
	        pq.add(answer);
	        answer = "";
	 		return;
	 	}
	 	//반복구문
	 	for(int i=start; i<N; i++) {
	 		b[cnt] = a[i];
	 		comb(cnt+1, i+1);
	 	}
	 }//comb
    */


}
