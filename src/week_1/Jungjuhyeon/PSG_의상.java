package week_1.Jungjuhyeon;

import java.io.*;
import java.util.*;

public class PSG_의상 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[][] clothes = new String[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            clothes[i][0] = st.nextToken();
            clothes[i][1] =st.nextToken();
        }
        int answer = solution(clothes);

        System.out.println(answer);

    }

    static int solution(String[][] clothes) {

        HashMap<String,Integer> map= new HashMap<>();

        for(String[] clothe : clothes){
            String type = clothe[1];
            map.put(type,map.getOrDefault(type,0)+1);
        }

        int answer =1;

        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }

        answer -=1;

        return answer;
    }
}
