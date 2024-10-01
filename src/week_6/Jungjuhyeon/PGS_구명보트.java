package week_6.Jungjuhyeon;

import java.util.*;
public class PGS_구명보트 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들의 무게를 정렬합니다.
        int left = 0; // 배열의 시작 포인터
        int right = people.length - 1; // 배열의 끝 포인터
        int boats = 0; // 필요한 보트의 수

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람을 보트에 태우기
            }
            right--; // 무거운 사람을 보트에 태우기
            boats++; // 보트 하나 사용
        }

        return boats;
    }
    public static void main(String[] args){
        int [] people = new int[]{70,50,80,50};
        int s = solution(people,100);
        System.out.println(s);

    }
}


/*
class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);
        int length = people.length;
        int num = limit;
        int answer =0;

        for(int i=0;i<length;i++){
            if(people[i]==0)continue;
            answer++;
            limit -= people[i];
            people[i] =0;
            for(int j=length-1;j>i;j--){
                if(people[j]<=limit && people[j]!=0){
                    people[j]=0;
                    break;
                }
            }
            limit = num;
        }

        return answer;
    }
}
*/

//위에 코드는 시간초과가 떴다. o(n^2)이다보니..