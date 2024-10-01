package week_2.Jungjuhyeon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_올바른괄호 {
    public static void main(String[] args){
        String s1 = "()()";
        String s2= "(())()"	;
        String s3 = ")()("	;
        String s4 = "(()(";
        System.out.println((solution(s1)));
        System.out.println((solution(s2)));
        System.out.println((solution(s3)));
        System.out.println((solution(s4)));

    }
    static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push('(');
            }
            else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();

    }
}
