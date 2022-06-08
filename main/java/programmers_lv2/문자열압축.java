package programmers_lv2;

import java.util.Stack;

public class 문자열압축 {
    public int solution(String s) {
        int result = Integer.MAX_VALUE;

        for(int i = 1; i <= s.length() / 2 + 1; i++){
            result = Math.min(result, function(s, i));
            // System.out.println(function(s, i));
        }

        return result;
    }

    int function(String s, int N){
        Stack<String> stack = new Stack<>();

        int answer = 0;
        int length = s.length();
        int cnt = length / N;
        int flag = 1;   // 같은 문자열 2개 이상일 때 판별 용도

        for(int i = 0; i <= length - N; i += N){
            String newStr = s.substring(i, i + N);
            // System.out.print(newStr + ", ");

            if(!stack.isEmpty() && stack.peek().equals(newStr)){
                flag++;
            } else{
                stack.push(newStr);
                answer += N;

                if(flag > 1){
                    answer += (int)(Math.log10(flag) + 1);  // flag의 자릿수에 따라 길이 변경되는 것 주의
                    flag = 1;
                }
            }
        }

        if(flag > 1){
            answer += (int)(Math.log10(flag) + 1);
        }

        if(length % N != 0) answer += length % N;

        // System.out.println(stack);

        return answer;
    }
}
