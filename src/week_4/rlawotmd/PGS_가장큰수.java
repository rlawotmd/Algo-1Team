package week_4.rlawotmd;

import java.math.BigInteger;
import java.util.Arrays;

public class PGS_가장큰수 {
    static String solution(int[] numbers) {
        // sorting을 할 것인데, int로 할 경우 무조건 큰 숫자가 앞으로 오거나 뒤로 갈수 밖에 없기 때문에
        // String으로 변환 후, sort를 진행
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (str[0].equals("0")) { // 배열에 전체 값이 0일 경우 0의 개수만큼 붙어서 나가기에 이를 방지
            return "0";
        }

        return String.join("", str); // String join Method 활용
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {6, 10, 2};
        System.out.println(solution(numbers));

        numbers = new int[] {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));

        numbers = new int[] {0, 0, 0, 0, 0};
        System.out.println(solution(numbers));
    }
}
/*
    compareTo에서는 기준값과 비교했을 때 동일하면 0, 기준값보다 작으면 1, 기준값보다 크면 -1을 리턴한다.
    String에서 비교할때는 한 문자의 아스키 코드 값으로 비교

    @HotSpotIntrinsicCandidate
    public static int compareTo(byte[] value, byte[] other) {
        int len1 = value.length;
        int len2 = other.length;
        return compareTo(value, other, len1, len2);
    }

    public static int compareTo(byte[] value, byte[] other, int len1, int len2) {
        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (value[k] != other[k]) {
                return getChar(value, k) - getChar(other, k);
            }
        }
        return len1 - len2;
    }

    코드를 보면 더 작은 길이의 크기만큼 반복문을 돌며 char 값으로 비교하는 것을 볼 수 있다.
    만약 중간에 다른 값이 발견된다면 그 char의 아스키코드 값으로 비교, 중간에 다른 값을 찾지 못하면 길이로 비교를 한다.
    대소문자 구분없이 사용을 하고싶다면 compareToIgnoreCase를 활용
 */