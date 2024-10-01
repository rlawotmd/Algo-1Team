package week_10.rlawotmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int mid;
        int start = 0;
        int end = arr[n - 1] - arr[0];
        int cnt;
        int loc;
        int answer = arr[n - 1] - arr[0];

        while (start <= end) {
            loc = arr[0];
            mid = (start + end) / 2;
            cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - loc >= mid) {
                    cnt++;
                    loc = arr[i];
                }
            }
            if (cnt < c) {
                end = mid - 1;
            }
            else {
                answer = mid;
                start = mid + 1;
            }

        }
        System.out.println(answer);
    }
}
