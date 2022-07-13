package programmers_lv2;

import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < N; i++){

            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // System.out.println(Arrays.toString(answer));
        // System.out.println(stack);

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = N - 1 - idx;
        }

        return answer;
    }
}
