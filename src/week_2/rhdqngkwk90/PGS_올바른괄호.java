package week_2.rhdqngkwk90;

import java.util.*;

public class PGS_올바른괄호 {

    static String s = ")()(";

    public static void main(String[] args) {
        boolean answer = solution(s);
        //return answer;
        System.out.println(answer);
    }

    static boolean solution(String s) {

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(') st.push('(');
            else {
                if(!st.isEmpty()) st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
