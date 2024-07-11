package week_1.rlawotmd;

import java.util.HashSet;
import java.util.Set;

public class ETC_EqualTest {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("A");
        s1.add("C");
        s1.add("B");

        HashSet<String> s2 = new HashSet<>();
        s2.add("A");
        s2.add("B");
        s2.add("C");

        System.out.println(s1.equals(s2));
    }
}
