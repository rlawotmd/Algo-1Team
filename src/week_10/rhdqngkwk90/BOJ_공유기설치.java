package week_10.rhdqngkwk90;

import java.util.Arrays;

public class BOJ_공유기설치 {

    //입력
    static int N = 5; //집의 개수
    static int C = 3; //공유기 개수
    static int[] arr = {1, 2, 8, 4, 9}; //집의 좌표

//    static int N; //집의 개수
//    static int C; //공유기 개수
//    static int[] arr; //집의 좌표

    public static void main(String[] args) throws Exception {

        /*
        공유기 사이의 최대, 최소 길이를 범위로 지정
        중간에 설치하는 지점을 이진탐색으로 점점 좁혀가기
        거리 사이에 공유기를 설치할 수 있는지 확인, 최대 거리 구하기
        */

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        N = Integer.parseInt(st.nextToken()); //집개수
//        C = Integer.parseInt(st.nextToken()); //공유기개수 　
//
//        arr = new int[N];
//        for(int i=0; i<N; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            arr[i] = Integer.parseInt(st.nextToken());
//        }

        Arrays.sort(arr); // 1, 2, 4, 8, 9

        int answer = binarySearch(arr);
        System.out.println(answer);

    }//main

    static int binarySearch(int[] arr) {
        int start = 1; //최소길이 2 - 1 = 1
        int end = arr[N - 1] - arr[0]; //최대길이 : 9 - 1 = 8
        int maxLength = 0;
        int distance = 0;

        //start가 end보다 작거나 같을 때 까지 반복.
        while (start <= end) {

            int mid = (start + end) / 2; //중간 길이 : 4 (길이 자체만 보는거라 시작위치를 더해주지 않는다.)
            int ap = arr[0]; //공유기 설치 시작 위치
            int cnt = 1; //공유기 설치 개수

            //시작위치 0, 중간길이 4 일 때, 1 _ _ 8 _ 공유기 설치 가능
            for (int i = 0; i < N; ++i) {
                distance = arr[i] - ap;  // 집마다 거리 체크
                if (distance >= mid) {   // 중간길이 이상으로 공유기 설치 가능한지 여부 체크
                    cnt++;
                    ap = arr[i];         // 설치 했다면 여기 집 부터 다시 거리 체크
                }
            }

            //중간길이가 4일 때, 공유기는 2개만 설치 가능, C보다 작다.
            if (cnt >= C) {
                maxLength = mid;
                start = mid + 1;  // 최소길이를 늘리기
            } else {
                end = mid - 1; // 최대길이를 줄이기
            }

        }
        return maxLength;
    } //binarySearch

}
