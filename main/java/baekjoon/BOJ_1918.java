package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1918 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		sc.close();
		
		Stack<Character> op = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			switch(arr[i]) {
				case '(':
					op.push(arr[i]);
					break;
				case ')':
					while(!op.isEmpty() && op.peek() != '(') {
						sb.append(op.pop());
					}
					op.pop();
					break;
				case '*': case '/':
					if(op.isEmpty() || (op.peek() != '*' && op.peek() != '/'))
						op.push(arr[i]);
					else {
						while(!(op.isEmpty() || (op.peek() != '*' && op.peek() != '/'))) 
							sb.append(op.pop());
						op.push(arr[i]);
					}
					break;
				case '+': case '-':
					if(op.isEmpty() || op.peek() == '(')
						op.push(arr[i]);
					else {
						while(!(op.isEmpty() || op.peek() == '('))
							sb.append(op.pop());
						op.push(arr[i]);
					}
					break;
				default:
					sb.append(arr[i]);
					break;
			}
		}
//		System.out.println(op);
		
		while(!op.isEmpty())
			sb.append(op.pop());
		
		System.out.println(sb);
	}
}
