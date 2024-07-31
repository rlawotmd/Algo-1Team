package week_3.Jungjuhyeon;

import java.io.*;
import java.util.*;

public class BOJ_절대값힙_11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {
            int abs1 =Math.abs(o1);
            int abs2 =Math.abs(o2);
            return abs1==abs2 ? Integer.compare(o1,o2) : Integer.compare(abs1,abs2);
        });
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(num);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
