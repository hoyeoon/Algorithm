package programmers_lv2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
