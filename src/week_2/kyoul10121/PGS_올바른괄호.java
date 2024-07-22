package week_2.kyoul10121;

import java.util.Stack;

public class PGS_올바른괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }
    static boolean solution(String s) {

        Stack<Character> stackChar = new Stack<>();
        // '(':push , ')':pop
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackChar.push('(');
            } else if (s.charAt(i) == ')') {
                if (stackChar.isEmpty()) {  //문자열의 길이가 0일때
                    return false;
                }
                stackChar.pop();
            }
        }
        return stackChar.isEmpty();
    }
}
