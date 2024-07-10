package week_1.rhdqngkwk90;

import java.util.*;

public class PGS_전화번호목록 {

    static String[] phone_book = {"119", "97674223", "1195524421"};

    static String text;
    static int arrLength, textLength;

    public static void main(String[] args) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();

        Integer s = 0;
        for(String str : phone_book) {
            map.put(str, s);
            s++;
        }
        arrLength = phone_book.length;
        for (int i=0; i<arrLength; i++) {
            text = phone_book[i];
            textLength = text.length();
            for (int j=1; j<textLength; j++) {
                if (map.containsKey(text.substring(0, j))) {
                    answer = false;
                    break;
                }
            }
            if(!answer) break;
        }

        /*
        //두 번째 풀이 - 시간초과
        Map<String, Integer> map = new HashMap<>();
        Integer i = 0;
        for(String str : phone_book){
            map.put(str, i);
            i++;
        }
        for(int j=0; j<phone_book.length; j++){
            int length = phone_book[j].length();
            for(String str : phone_book){
                if(str.length() > length && map.containsKey(str.substring(0, length))){
                    answer = false;
                    break;
                }
            }
        }

        //첫 번째 풀이 - 시간초과
        for(int i=0; i<phone_book.length; i++) {
        	String str = phone_book[i]; //비교할 텍스트
        	int strLength = str.length(); //비교할 텍스트 길이

        	for(String text : phone_book) {
    			int textLength = text.length();
        		if(!text.equals(str) && textLength >= strLength) {
                    String splitText = text.substring(0, strLength);
                    if(str.equals(splitText)) {
                        answer = false;
                        break;
                    }
        		}
        	}

        }
        */

        //return answer;
        System.out.println(answer); //false

    }
}
