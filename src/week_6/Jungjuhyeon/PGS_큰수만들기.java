package week_6.Jungjuhyeon;

public class PGS_큰수만들기 {
    public static String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int max =0;
        int idx =0;

        for(int i=0;i<number.length()-k;i++){
            max =0;
            for(int j=idx;j<=k+i;j++){
                if(max<number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }

        return sb.toString();


    }

    public static void main(String[] args){
        int[] lost = new int[] {2,4};
        int[] reserve = new int[]{1,3,5};
        String s = solution("1924",2);
        System.out.println(s);

    }
}
//ㅈ같은 문제다.
// 1. number.length()-k 길이만큼 숫자를 뽑아내야한다.
// 2. 범위내에서 한개를 선택해도 뒤에 숫자와 합쳐서 number.length()-k와 같아져야한다. 이를 잘 봐야한다