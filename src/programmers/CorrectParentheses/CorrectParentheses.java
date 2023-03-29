package programmers.CorrectParentheses;

import java.util.Stack;

public class CorrectParentheses {

    public static void main(String[] args) {
        CorrectParenthesesSolution sol = new CorrectParenthesesSolution();

//        String s = "()()";
        String s = "(())()";
        System.out.println(sol.solution(s));

    }
}

class CorrectParenthesesSolution {

    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if('('==s.charAt(i)){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
