package programmers_lv2;

import java.util.Stack;

public class 괄호변환 {
    public String solution(String p) {
        return function("", p);
    }

    private String[] splitBalancedStr(String w){
        int left = 0;
        int right = 0;
        String u = "";
        String v = "";

        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i) == '('){
                left++;
            } else{
                right++;
            }
            if(left == right){
                u = w.substring(0, i + 1);
                v = w.substring(i + 1);
                break;
            }
        }

        return new String[]{u, v};
    }

    private boolean checkCorretStr(String u){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < u.length(); i++){
            char curr = u.charAt(i);

            if(!stack.isEmpty() && stack.peek() == '(' && curr == ')'){
                stack.pop();
            } else{
                stack.push(curr);
            }
        }

        return stack.isEmpty() ? true : false;
    }

    private String reverseBracket(String str){
        String result = "";

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                result += ')';
            } else{
                result += '(';
            }
        }
        return result;
    }

    private String removeFirstAndLastStr(String str){
        return str.substring(1, str.length() - 1);
    }

    private String function(String answer, String w){
        // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        if(w.equals("")) return "";

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리
        String[] balancedStrs = splitBalancedStr(w);
        String u = balancedStrs[0];
        String v = balancedStrs[1];

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행
        if(checkCorretStr(u)){
            return u + function(answer, v); // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환
        } else{ // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
            String temp = "("; // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            temp += function(answer, v); // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            temp += ")"; // 4-3. ')'를 다시 붙입니다.
            temp += reverseBracket(removeFirstAndLastStr(u)); //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            return temp; // 4-5. 생성된 문자열을 반환합니다.
        }
    }
}
