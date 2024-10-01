package week_2.rlawotmd;

import java.util.LinkedList;
import java.util.Queue;

public class ETC_justTest {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 10; i++) q.offer(i);

        int c = 1;

        for (int i = 0; i < 25; i++) {
            if (c++ % 2 == 0) {
                Integer n = q.poll();
                System.out.println("drop : " + n);
            }
            System.out.println(q);
            System.out.println(q.peek());
            q.offer(q.poll());
        }

        // 여기서는 아무 문제가 없는데....? 아마 poll에서 null을 반환해서 그런거 같다.
        // >>> int는 null을 저장 불가, 하지만 Integer은 null을 저장 할 수 있어서 에러가 뜨지 않는다.
        // 그저 널을 반활해서 그런거 같다.
    }
}
