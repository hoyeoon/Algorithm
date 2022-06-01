package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_5432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr;
		int cnt, answer;
		Stack<Character> stack;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			arr = br.readLine().toCharArray();
			stack = new Stack<>();
			cnt = 0;
			answer = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == '(') {
					cnt = 0;
					stack.push(arr[i]);
				}else {
					cnt++;
					stack.pop();
					
					if(cnt == 1)
						answer += stack.size();
					else
						answer += 1;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
