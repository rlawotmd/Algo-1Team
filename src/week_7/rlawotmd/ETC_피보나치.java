package week_7.rlawotmd;

public class ETC_피보나치 {
    static int cnt = 1;

    static long[] arr;

    static long f(int n) { // 단순 재귀 구현
        System.out.println("호출 : " + cnt++);
        if (n <= 1) return 1;
        return f(n - 1) + f(n - 2);
    }

    static long f2(int n) { // Bottom-Up 방식 DP 구현
        long[] arr = new long[(int) (n + 1)];
        arr[0] = 1;
        arr[1] = 1;
        for (long i = 2; i <= n; i++) {
            arr[(int) i] = arr[(int) (i - 1)] + arr[(int) (i - 2)];
        }
        return arr[n];
    }

    static long f3(int n) { // Top-Down 방식 DP 구현
        if (arr[n] != 0) return arr[n];
        arr[n] = f3(n - 1) + f3(n - 2);
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(f(100));
        System.out.println(f2(100));

        arr = new long[100 + 1];
        arr[0] = 1;
        arr[1] = 1;
        System.out.println(f3(100));
    }
}
