package week_4.rhdqngkwk90;

import java.io.*;
import java.util.*;

public class BOJ_나이순정렬 {

    //입력
    static int N = 3;

    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;

//        int N = Integer.parseInt(br.readLine()); //줄의 개수
        //String[][] arr = new String[N][2];

//        for(int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            arr[i][0] = st.nextToken();
//            arr[i][1] = st.nextToken();;
//        }

        //입력
        String[][] arr = {{"21","Junkyu"},{"21","Dohyun"},{"20","Sunyoung"}};

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
            }

        });

        for(int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

//        br.close();
    }
}
