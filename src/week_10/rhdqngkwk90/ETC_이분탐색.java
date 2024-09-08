package week_10.rhdqngkwk90;

public class ETC_이분탐색 {

    static int[] arr = {10, 13, 17, 30, 41, 45};
    static int key = 41;

    //출력
    public static void main(String[] args) {
        System.out.println(" === 반복문으로 구현 === ");
        int answer1 = binarySearch1(arr, 41);
        System.out.println("key의 인덱스값 : " + answer1);

        System.out.println(" === 재귀로 구현 === ");
        int answer2 = binarySearch2(arr, 0, arr.length - 1, key);
        System.out.println("key의 인덱스값 : " + answer2);
    }


    //1. 반복문으로 구현
    static int binarySearch1(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        //start가 end보다 작거나 같을 때 까지 반복.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) return mid; //같으면 종료

            //시작, 종료 위치 변경
            if (arr[mid] > key) {
                end = mid - 1;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            }
        }
        // start > end 이라면 -1을 반환하고 종료.
        return -1;
    } //binarySearch1

    //2. 재귀로 구현
    static int binarySearch2(int[] arr, int start, int end, int key) {
        if (start > end) return -1; //백트래킹

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) return mid; //같으면 종료

        if (arr[mid] > key) {
            return binarySearch2(arr, start, mid - 1, key);
        } else {
            return binarySearch2(arr, mid + 1, end, key);
        }
    } //binarySearch2
}
