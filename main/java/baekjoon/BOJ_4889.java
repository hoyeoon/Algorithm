package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr;
		Stack<Character> stack;
		
		int t = 1;
		while(true) {
			String str = br.readLine();
			if(str.contains("-")) {
				break;
			}
			sb.append(t++).append(". ");
			arr = str.toCharArray();
			stack = new Stack<>();
			
			stack.push(arr[0]);
			for(int i = 1; i < arr.length; i++) {
				if(!stack.isEmpty() && stack.peek() == '{' && arr[i] == '}') {
					stack.pop();
					continue;
				}
				stack.push(arr[i]);
			}
//			System.out.println(stack);
			
			if(stack.isEmpty()) {
				sb.append(0);
			}else {
				int cnt = 0;
				if(stack.pop() == '{') cnt++; 
				char prev = '}';
				while(!stack.isEmpty()) {
					if(stack.peek() == '{') {
						if(prev == '{') {
							cnt++;
							prev = '}';
						}else {
							prev = '{';
						}
					}else {
						if(prev == '}') {
							cnt++;
							prev = '{';
						}else {
							prev = '}';
						}
					}
					stack.pop();
				}
				sb.append(cnt);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
