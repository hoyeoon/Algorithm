package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_1234 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			char[] arr = st.nextToken().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < n; i++) {
				if(stack.isEmpty()) {
					stack.push(arr[i]);
					continue;
				}
				if(stack.peek() == arr[i]) {
					stack.pop();
				}else {
					stack.push(arr[i]);
				}
			}
			String answer = "";
			while(!stack.isEmpty()) {
				answer = stack.pop() + answer;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}