package week_1.Jungjuhyeon;

import java.io.*;
import java.util.*;
public class PGS_전화번호목록 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] phone_book = br.readLine().split(" ");

        if(solution(phone_book)){
            System.out.println("true");
        }else{
            System.out.println("false");

        }

    }
    static boolean solution(String[] phone_book) {

        HashMap<String,Integer> map = new HashMap<>();

        for(String str : phone_book){
            map.put(str,1);
        }

        for(String str : phone_book){
            for(int i=1;i<str.length();i++){
                String prefix = str.substring(0,i);
                if(map.containsKey(prefix)) return false;
            }
        }

        return true;
    }

}
