package week_4.rlawotmd;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = String.valueOf(i);
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
        }

        Arrays.sort(arr, (o1, o2) -> o1[1].equals(o2[1])
                ? Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]))
                : Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1])));

        for (String[] s : arr) bw.write(s[1] + " " + s[2] + "\n");

        bw.flush();
    }
}
/*
12
21 Junkyuz
21 Dohyunz
20 Sunyoungz
21 Junkyuf
21 Dohyunf
20 Sunyoungf
21 Junkyud
21 Dohyund
20 Sunyoungd
21 Junkyus
21 Dohyuns
20 Sunyoungs

String 배열 소팅을 할 때 String으로 하다 Integer로 바꾼 이유 :
만약 111과 9를 비교한다고 예시를 들면 숫자로 봤을때는 당연하게도 111이 더 큰 값이다.
그런데 이를 스트링으로 비교하게 된다면 하나의 캐릭터 값으로만 비교를 하기 때문에 사전 순으로 정렬이 되게 된다.
그리하여 111보다 9가 더 크다고 받아들이게 된다.
그래서 뒤에서는 Integer로 받아서 사용했습니다.

900ms 이상
 */