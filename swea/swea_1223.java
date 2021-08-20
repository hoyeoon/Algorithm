package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1223 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack<>();
		Stack<Integer> num = new Stack<>();
		StringBuilder postfix;
		char infixArr[], postfixArr[];
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			postfix = new StringBuilder();
			
			br.readLine();
			infixArr = br.readLine().toCharArray();
			
			// 1. 후위표기식으로 변환
			for(int i = 0; i < infixArr.length; i++) {
				if(infixArr[i] >= '0' && infixArr[i] <= '9') {
					postfix.append(infixArr[i]);
				}else {
					if(op.isEmpty()) { // 스택이 비어있으면 무조건 추가
						op.push(infixArr[i]);
					}else {				// 스택이 비어있지 않을 경우
						if(infixArr[i] == '+') {
							if(op.peek() == '*') {
								while(!op.isEmpty())
									postfix.append(op.pop());
								op.push(infixArr[i]);
							}else {
								postfix.append(infixArr[i]);
							}
						}else {	// '*' 일 경우
							if(op.peek() == '+') {
								op.push(infixArr[i]);
							}else {
								while(!op.isEmpty() && op.peek() == '*') {
									postfix.append(op.pop());
								}
								op.push(infixArr[i]);
							}
						}
					}
				}
			}
			while(!op.isEmpty()) postfix.append(op.pop());	// 스택에 남아있는 op pop
			postfixArr = postfix.toString().toCharArray();
			
			// 2. 변환된 후위표기식 활용하여 계산
			for(int i = 0; i < postfixArr.length; i++) {
				if(postfixArr[i] >= '0' && postfixArr[i] <= '9') {
					num.push(postfixArr[i] - '0');
				}else {
					int v2 = num.pop();
					int v1 = num.pop();
					
					if(postfixArr[i] == '*') {
						num.push(v1 * v2);
					}else {
						num.push(v1 + v2);
					}
				}
			}
			sb.append(num.pop()).append("\n");
		}
		System.out.println(sb);
	}
}
