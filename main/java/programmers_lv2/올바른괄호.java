package programmers_lv2;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : arr){
            if(stack.isEmpty() || c == '('){
                stack.push(c);
            } else{
                if(stack.peek() == '('){
                    stack.pop();
                } else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
