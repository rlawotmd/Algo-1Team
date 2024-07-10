package week_1.Jungjuhyeon;

import java.util.*;
import java.io.*;

public class PGS_완주하지못한선수 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] p_inputAry = br.readLine().split(" ");
        String[] c_inputAry = br.readLine().split(" ");

        String ans = solution(p_inputAry,c_inputAry);

        System.out.println(ans);

    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String player : participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for(String player : completion ){
            map.put(player, map.get(player) - 1);
        }

        for(String key : map.keySet()) {
            if (map.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }

}
