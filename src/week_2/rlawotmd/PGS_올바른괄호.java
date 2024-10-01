package week_2.rlawotmd;

import java.util.Stack;

public class PGS_올바른괄호 {
    static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>(); // char형 자료를 넣을 스택을 생성

        for (int i = 0; i < s.length(); i++) { // 문자열의 길이만큼 for문 실행
            if (s.charAt(i) == '(') stack.push('('); // '('일 경우 stack에 저장
            else if (s.charAt(i) == ')') { // ')'일 경우 스택이 비어있는지 확인
                if (stack.isEmpty()) return false; // 바로 ')'가 온다면 열려있지도 않은 괄호를 닫는 것이기 때문에 틀린 문자열
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return false; // 반복문이 끝난 후 스택이 비어 있지 않다면 아직 열린 괄호가 있다는 의미

        return answer;
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));

        s = "(())()";
        System.out.println(solution(s));

        s = ")()(";
        System.out.println(solution(s));

        s = "(()(";
        System.out.println(solution(s));
    }
}
// 효율성 테스트 부분 : 18.69 ms / 21.1 ms