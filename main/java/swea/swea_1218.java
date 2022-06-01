package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1218 {
	static int n;
	static char[] arr;
	static Stack<Character> stack;
	static int flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			n = Integer.parseInt(br.readLine());
			arr = br.readLine().toCharArray();
			stack = new Stack<>();
			flag = 1;
			outer : for(int i = 0; i < n; i++) {
				switch(arr[i]) {
				case '(': case '{': case '[': case '<':
					stack.push(arr[i]);
					break;
				case ')':
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = 0;
						break outer;
					}
					stack.pop();
					break;
				case '}':
					if(stack.isEmpty() || stack.peek() != '{') {
						flag = 0;
						break outer;
					}
					stack.pop();
					break;
				case ']':
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = 0;
						break outer;
					}
					stack.pop();
					break;
				case '>':
					if(stack.isEmpty() || stack.peek() != '<') {
						flag = 0;
						break outer;
					}
					stack.pop();
					break;
				}
			}
			if(!stack.isEmpty())
				flag = 0;
			sb.append(flag).append("\n");
		}
		System.out.println(sb);
	}
}
