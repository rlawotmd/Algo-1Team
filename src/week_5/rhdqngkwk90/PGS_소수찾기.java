package week_5.rhdqngkwk90;

import java.util.*;
import java.util.stream.Collectors;

public class PGS_소수찾기 {

    //입력
    static String numbers = "011";

    static int N, R = 1, C = 0;
    static String[] a, b;
    static boolean[] v;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args){
        int answer = solution(numbers);
        System.out.println(answer);
    }

    static int solution(String numbers) {
        int answer = 0;

        a = numbers.split("");
        N = a.length;
        v = new boolean[N];

        //1. 문자열로 만들 수 있는 숫자 조합 생성 - 순열
        C = 0;
        for(int q=0; q<N; q++){
            b = new String[R];
            perm(0);
            R++;
        }

        //2. 각 숫자 조합이 소수인지 확인
        List<String> newList = list.stream().distinct().collect(Collectors.toList()); //중복제거
        list = new ArrayList<>(); //list 재사용
        for(String s : newList){
            if(!"1".equals(s) && !"0".equals(s) && '0'!=s.charAt(0)) {
                if(isPrime(Integer.parseInt(s))) {
                    //System.out.println(s+"는 소수? "+isPrime(Integer.parseInt(s)));
                    answer++;
                }
            }
        }
        return answer;
    }

    //순열
    static void perm(int cnt) {
        //탈출
        if(cnt==R) {
            String num = "";
            for(String s : b) num += s;
            list.add(num);
            C++;
            return;
        }
        //반복
        for(int i=0; i<N; i++) {
            if(v[i]) continue;
            v[i] = true;
            b[cnt] = a[i];
            perm(cnt+1);
            v[i] = false;
        }
    }

    //소수
    static boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
