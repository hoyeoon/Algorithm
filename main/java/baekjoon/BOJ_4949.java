package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str;
		Stack<Character> stack;
		String answer;
		
		while(true) {
			str = br.readLine().toCharArray();
			
			if(str.length == 1 && str[0] == '.')
				break;
			
			stack = new Stack<>();
			answer = "yes";
			
			outer : for(int i = 0; i < str.length; i++) {
				switch(str[i]) {
					case '(': case '[': 
						stack.push(str[i]);
						break;
					case ')':
						if(stack.isEmpty() || stack.peek() == '[') {
							answer = "no";
							break outer;
						}
						stack.pop();
						break;
					case ']':
						if(stack.isEmpty() || stack.peek() == '(') {
							answer = "no";
							break outer;
						}
						stack.pop();
						break;
				}
			}
			if(!stack.isEmpty())
				answer = "no";
			System.out.println(answer);
		}
	}
}
